package assembly.annotationtest.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
/**
 * @Component
 * 代表SpringIoc会把这个类扫描成Bean实例，value代表这个类在spring中的id，直接使用@Component没有参数的，springIoc使用默认参数类名
 * @Value
 * 代表值的注入
 */
@Component(value = "role")
public class Role {

    @Value("1")
    private Long id;
    @Value("role_name_1")
    private String roleName;
    @Value("role_note_1")
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
