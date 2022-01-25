package duo.cmr.willagroapp.persistence.db.person;

import duo.cmr.willagroapp.persistence.domain.entitees.Person;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Objects;

@Table("person")
public  class PersonDTO {
    @Id
    private  Long id;
    private  String name;
    private  String email;
    private  String telephone;

    public PersonDTO(String name, String email, String telephone) {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
    }

    public Person toPerson() {
        return new Person(name, email, telephone);
    }

    @Id
    public Long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String email() {
        return email;
    }

    public String telephone() {
        return telephone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (PersonDTO) obj;
        return Objects.equals(this.id, that.id) &&
               Objects.equals(this.name, that.name) &&
               Objects.equals(this.email, that.email) &&
               Objects.equals(this.telephone, that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, telephone);
    }

    @Override
    public String toString() {
        return "PersonDTO[" +
               "id=" + id + ", " +
               "name=" + name + ", " +
               "email=" + email + ", " +
               "telephone=" + telephone + ']';
    }

}
