package backend.user;

import org.apache.commons.lang3.StringUtils;

/**
 * Clase User es la clase encargada de representar a un usuario dentro de la
 * apicacion
 *
 * @author YmCris
 * @since Sep 18, 2025
 */
public class User {

    // VARIABLES DE REFERENCIA -------------------------------------------------
    private String name;
    private String dpi;
    private String phoneNumber;
    private String email;
    private String password;
    private String photo;
    private String institutionName;

    // VARIABLES PRIMITIVAS ----------------------------------------------------
    private boolean foreign;
    private boolean active;

    // MÉTODO CONSTRUCTOR ------------------------------------------------------
    public User(String name, String dpi, String phoneNumber, String email, String password, String photo, String institutionName, boolean foreign, boolean active) {
        this.name = name;
        this.dpi = dpi;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.photo = photo;
        this.institutionName = institutionName;
        this.foreign = foreign;
        this.active = active;
    }

    // MÉTODOS CONCRETOS -------------------------------------------------------
    public boolean parametersAreCorrect() {
        return StringUtils.isNotBlank(name)
                && StringUtils.isNotBlank(dpi)
                && StringUtils.isNotBlank(phoneNumber)
                && StringUtils.isNotBlank(email)
                && StringUtils.isNotBlank(password)
                && StringUtils.isNotBlank(photo)
                && StringUtils.isNotBlank(institutionName);
    }
    // GETTERS -----------------------------------------------------------------

    public String getName() {
        return name;
    }

    public String getDpi() {
        return dpi;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoto() {
        return photo;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public boolean isForeign() {
        return foreign;
    }

    public boolean isActive() {
        return active;
    }
    // SETTERS -----------------------------------------------------------------

}
