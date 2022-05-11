package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.RoleService;
import cinema.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;

    public DataInitializer(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @PostConstruct
    public void inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);
        User testAdmin = new User();
        testAdmin.setEmail("testAdmin@gmail.com");
        testAdmin.setPassword("testPassword");
        testAdmin.setRoles(Set.of(adminRole));
        userService.add(testAdmin);
        User testUser = new User();
        testUser.setEmail("testUser@gmail.com");
        testUser.setPassword("testPassword");
        testUser.setRoles(Set.of(adminRole));
        userService.add(testUser);

    }
}