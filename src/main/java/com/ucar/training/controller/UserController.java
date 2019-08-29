package com.ucar.training.controller;

import com.ucar.training.entity.TMenu;
import com.ucar.training.entity.TRole;
import com.ucar.training.entity.User;
import com.ucar.training.entity.UserMessage;
import com.ucar.training.service.MenuService;
import com.ucar.training.service.MessageService;
import com.ucar.training.service.RoleService;
import com.ucar.training.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private  UserService userService;
    @Resource
    private MenuService menuService;
    @Resource
    private MessageService messageService;
    @Resource
    private RoleService roleService;

    @RequestMapping("/registerRequest")
    public String register(HttpServletRequest request, HttpServletResponse response) throws IOException{
        User user=getRequestUser(request);;
        userService.register(user);
        response.getWriter().print("<script language='javascript'>alert('register successfully ！');window.location='register.jsp';</script>");
        return null;
    }

    @RequestMapping("/ajaxJudgeRequest")
    public void ajaxJudge(String username,HttpServletResponse response) throws IOException{
        if (userService.inUsers(username)){
            response.getWriter().print(1);
        }
        else {
            response.getWriter().print(0);
        }
    }
    @RequestMapping("/loginRequest")
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int var=userService.login(username,password);
        if (var==0){
            //密码正确
            User userNow=userService.findUser(username);
            request.getSession().setAttribute("userNow",userNow);
            request.getSession().setAttribute("userMenu",userService.getUserMenu(userNow));
            if (userNow.getRole()==1){
                request.setAttribute("users",userService.getUsers());
            }
            return "userInfo.jsp";
        }
        else if(var==1)
        {
            //密码不正确
            response.getWriter().print("<script language='javascript' charset = \"UTF-8\">alert('密码不正确！');window.location='login.jsp';</script>");
            return null;
        }
        else {
            //用户名不存在
            response.getWriter().print("<script language='javascript' charset = \"UTF-8\">alert('用户名不存在！');window.location='login.jsp';</script>");
            return null;
        }
    }

    @RequestMapping("/userManageRequest")
    public String userManage(Model model){
        model.addAttribute("users",userService.getUsers());
        return "userInfo.jsp";
    }

    @RequestMapping("/modifyUserRequest")
    public String modifyUser(String username,Model model){
        model.addAttribute("modifiedUser",userService.findUser(username));
        return "modifyUser.jsp";
    }

    @RequestMapping("/updateUserRequest")
    public String updateUser(HttpServletRequest request){
        User user=getRequestUser(request);
        userService.updateUser(user);
        request.setAttribute("users",userService.getUsers());
        return "userInfo.jsp";
    }

    @RequestMapping("/delUserRequest")
    public String delUser(String username,Model model){
        userService.delUser(username);
        model.addAttribute("users",userService.getUsers());
        return "userInfo.jsp";
    }

    private User getRequestUser(HttpServletRequest request) {
        String username=request.getParameter("username");
        String realName=request.getParameter("realName");
        String sex=request.getParameter("sex");
        String age=request.getParameter("age");
        String password=request.getParameter("password");
        String tel=request.getParameter("tel");
        String email=request.getParameter("email");
        String[] hobbiesArr=request.getParameterValues("hobbies");
        StringBuilder hobbies=new StringBuilder();
        if (hobbiesArr==null){
            hobbies.append("无");
        }
        else {
            for (int i = 0; i <hobbiesArr.length ; i++) {
                hobbies.append(hobbiesArr[i]+",");
            }
            hobbies.delete(hobbies.length()-1,hobbies.length());
        }
        String sign=request.getParameter("sign");
        String privilege=request.getParameter("role");
        User user=new User();
        user.setUsername(username);
        user.setRealName(realName);
        user.setAge(age);
        user.setSex(sex);
        user.setPassword(password);
        user.setTel(tel);
        user.setEmail(email);
        user.setHobbies(hobbies.toString());
        user.setSign(sign);
        user.setRole(Integer.parseInt(privilege));
        return user;
    }

    @RequestMapping("/messageRequest")
    public String messageBord(Model model){
        model.addAttribute("userMessages",messageService.getUserMessages());
        return "messageBord.jsp";
    }

    @RequestMapping("/addMessageRequest")
    public String addMessage(HttpServletRequest request){
        String username=request.getParameter("nowUsername");
        String messageTitle=request.getParameter("messageTitle");
        String messageContent=request.getParameter("messageContent");
        UserMessage userMessage=new UserMessage();
        userMessage.setUsername(username);
        userMessage.setMessageTitle(messageTitle);
        userMessage.setMessageContent(messageContent);
        messageService.addMessage(userMessage);
        request.setAttribute("userMessages",messageService.getUserMessages());
        return "messageBord.jsp";
    }

    @RequestMapping("/delMessageRequest")
    public String delMessage(int messageID,Model model){
        messageService.delMessage(messageID);
        model.addAttribute("userMessages",messageService.getUserMessages());
        return "messageBord.jsp";
    }

    @RequestMapping("/menuInfoRequest")
    public String menuInfo(Model model){
        model.addAttribute("menus",menuService.getMenus());
        return "menu.jsp";
    }

    @RequestMapping("/addMenuRequest")
    public String addMenu(){
        return "menu.jsp";
    }

    @RequestMapping("/delMenuRequest")
    public String delMenu(int menuID,Model model){
        menuService.delMenu(menuID);
        model.addAttribute("menus",menuService.getMenus());
        return "menu.jsp";
    }

    @RequestMapping("/modifyMenuRequest")
    public String modifyMenu(int menuID,Model model){
        model.addAttribute("modifyMenu",menuService.getMenuByID(menuID));
        return "modifyMenu.jsp";
    }

    @RequestMapping("/updateMenuRequest")
    public String updateMenu(TMenu menu, Model model){
        menuService.modifyMenu(menu);
        model.addAttribute("menus",menuService.getMenus());
        return "menu.jsp";
    }

    @RequestMapping("/roleInfoRequest")
    public String roleInfo(Model model){
        model.addAttribute("roles",roleService.getAllRole());
        return "role.jsp";
    }
    @RequestMapping("/chooseMenuRequest")
    public String chooseMenu(Model model){
        model.addAttribute("menus",menuService.getMenus());
        return "addRole.jsp";
    }
    @RequestMapping("/addRoleRequest")
    public String addRole(HttpServletRequest request){
        String roleName=request.getParameter("roleName");
        String[] menu=request.getParameterValues("menu");
        roleService.addRole(roleName);
        int roleID=roleService.getRoleIDByName(roleName);
        for (int i = 0; i < menu.length; i++) {
            roleService.addRoleMenu(roleID,Integer.parseInt(menu[i]));
        }
        request.setAttribute("roles",roleService.getAllRole());
        return "role.jsp";
    }

    @RequestMapping("/delRoleRequest")
    public String delRole(int roleID,Model model){
        roleService.delRole(roleID);
        model.addAttribute("roles",roleService.getAllRole());
        return "role.jsp";
    }

    @RequestMapping("/modifyRoleRequest")
    public String modifyRole(int roleID,Model model){
        TRole role=roleService.getRoleByID(roleID);

        List<String> roleMenuName=new ArrayList<>();
        for(TMenu menu:role.getMenusList()){
            roleMenuName.add(menu.getMenuName());
        }
        model.addAttribute("modifyRole",role);
        model.addAttribute("menus",menuService.getMenus());
        model.addAttribute("roleMenuName",roleMenuName);
        return "modifyRole.jsp";
    }

    @RequestMapping("/updateRoleRequest")
    public String updateRole(HttpServletRequest request){
        String roleID=request.getParameter("roleID");
        String roleName=request.getParameter("roleName");
        String[] menu=request.getParameterValues("menu");

        roleService.delRole(Integer.parseInt(roleID));
        roleService.addRole(roleName);
        int roleID1=roleService.getRoleIDByName(roleName);
        for (int i = 0; i < menu.length; i++) {
            roleService.addRoleMenu(roleID1,Integer.parseInt(menu[i]));
        }
        request.setAttribute("roles",roleService.getAllRole());
        return "role.jsp";
    }
}
