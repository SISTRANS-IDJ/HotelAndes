package edu.uniandes.hotelandes.user.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleView {
    private final UserRoleController roleController;

        @Autowired
    public RoleView(UserRoleController roleController) {
        this.roleController = roleController;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("roles", roleController.listRoles());
        return "role";
    }

    @GetMapping("{id}/delete")
    public String bebedorBorrar(@PathVariable("id") Byte id) {
        roleController.deleteRole(id);
        return "redirect:/role";
    }
}