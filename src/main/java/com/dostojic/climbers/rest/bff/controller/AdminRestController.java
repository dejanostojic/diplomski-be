package com.dostojic.climbers.rest.bff.controller;
import com.dostojic.climbers.domain.Admin;
import com.dostojic.climbers.domain.Climber;
import com.dostojic.climbers.domain.valueobject.AdminSearchCriteria;
import com.dostojic.climbers.domain.valueobject.ClimberSearchCriteria;
import com.dostojic.climbers.logging.Loggable;
import com.dostojic.climbers.logic.so.admin.CreateAdmin;
import com.dostojic.climbers.logic.so.admin.DeleteAdmin;
import com.dostojic.climbers.logic.so.admin.FindAdmin;
import com.dostojic.climbers.logic.so.admin.SearchAdmins;
import com.dostojic.climbers.logic.so.admin.UpdateAdmin;
import com.dostojic.climbers.logic.so.climber.CreateClimber;
import com.dostojic.climbers.logic.so.climber.DeleteClimber;
import com.dostojic.climbers.logic.so.climber.FindClimber;
import com.dostojic.climbers.logic.so.climber.SearchClimbers;
import com.dostojic.climbers.logic.so.climber.UpdateClimber;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/admins")
public class AdminRestController {

  @Autowired
  private CreateAdmin createAdmin;

  @Autowired
  private SearchAdmins searchAdmins;

  @Autowired
  private UpdateAdmin updateAdmin;

  @Autowired
  private DeleteAdmin deleteAdmin;

  @Autowired
  private FindAdmin findAdmin;



  @GetMapping()
  @Loggable
  public Page<Admin> searchAdmins(AdminSearchCriteria adminSearchCriteria) {
    return searchAdmins.execute(adminSearchCriteria);
  }

  @PostMapping()
  @Loggable
  public Admin save(@Valid @RequestBody Admin admin) {
    return createAdmin.execute(admin);
  }

  @PutMapping("/{id}")
  @Loggable
  public Admin update(@PathVariable Long id, @Valid @RequestBody Admin admin) {
    admin.setId(id);
    updateAdmin.execute(admin);
    return admin;
  }

  @DeleteMapping("/{id}")
  @Loggable
  public void delete(@PathVariable Long id) {
    deleteAdmin.execute(id);
  }

  @GetMapping("/{id}")
  public Admin find(@PathVariable Long id) {
    return findAdmin.execute(id);
  }


}
