package dababase;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Clase DBCreation es la clase encargada de crear las tablas solamente si no
 * existen dentro del programa.
 *
 * @author YmCris
 * @since Sep 18, 2025
 * @deprecated 
 */
public class DBCreation {

    // CONSTANTES --------------------------------------------------------------
    private static final String SQL_CREATE_SYSTEM
            = "CREATE TABLE system ("
            + "description TEXT NOT NULL,"
            + "commission_percentage DECIMAL(5,2) NOT NULL"
            + ")";

    private static final String SQL_CREATE_USER
            = "CREATE TABLE user ("
            + "user_name VARCHAR(45) NOT NULL,"
            + "password VARCHAR(100) NOT NULL,"
            + "dpi VARCHAR(45) NOT NULL,"
            + "phone_number VARCHAR(20) NOT NULL,"
            + "institution_name VARCHAR(45),"
            + "photo BLOB NOT NULL,"
            + "is_foreign BOOLEAN NOT NULL,"
            + "active BOOLEAN NOT NULL,"
            + "CONSTRAINT pk_dpi PRIMARY KEY (dpi),"
            + "CONSTRAINT fk_institution_name FOREIGN KEY (institution_name) REFERENCES institution(institution_name)"
            + ")";

    private static final String SQL_CREATE_WALLET
            = "CREATE TABLE wallet ("
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "wallet_name VARCHAR(45) NOT NULL,"
            + "bank_name VARCHAR(45) NOT NULL,"
            + "fund DECIMAL(10,2) NOT NULL,"
            + "CONSTRAINT pk_wallet PRIMARY KEY (wallet_name,bank_name),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY (user_dpi) REFERENCES user(dpi)"
            + ")";

    private static final String SQL_CREATE_SYSTEM_ADMINS
            = "CREATE TABLE system_admins ("
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "CONSTRAINT pk_system_admins PRIMARY KEY(user_dpi),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY(user_dpi) REFERENCES user(dpi)"
            + ")";

    private static final String SQL_CREATE_CLIENT
            = "CREATE TABLE client ("
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "name VARCHAR(45) NOT NULL,"
            + "stonks DECIMAL(10,2) NOT NULL"
            + ")";

    private static final String SQL_CREATE_INSTITUTION
            = "CREATE TABLE institution ("
            + "institution_name VARCHAR(45) NOT NULL,"
            + "description TEXT NOT NULL,"
            + "ubication VARCHAR(45) NOT NULL,"
            + "CONSTRAINT pk_institution PRIMARY KEY(institution_name)"
            + ")";

    private static final String SQL_CREATE_CONFERENCE
            = "CREATE TABLE conference ("
            + "conference_name VARCHAR(45) NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "price DECIMAL(10,2) NOT NULL,"
            + "description TEXT NOT NULL,"
            + "start_date DATETIME NOT NULL,"
            + "end_date DATETIME NOT NULL,"
            + "ubication VARCHAR(45) NOT NULL,"
            + "institution_name VARCHAR(45) NOT NULL,"
            + "CONSTRAINT pk_conference PRIMARY KEY(conference_code),"
            + "CONSTRAINT fk_institution_name FOREIGN KEY(institution_name) REFERENCES institution(institution_name)"
            + ")";

    private static final String SQL_CREATE_CONFERENCE_ADMINS
            = "CREATE TABLE conference_admins ("
            + "conference_code VARCHAR(45) NOT NULL,"
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "CONSTRAINT pk_conference_admins PRIMARY KEY(conference_code, user_dpi),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY(user_dpi) REFERENCES user(dpi)"
            + ")";

    private static final String SQL_CREATE_BUILDING
            = "CREATE TABLE building ("
            + "building_name VARCHAR(45) NOT NULL,"
            + "ubication VARCHAR(45) NOT NULL,"
            + "CONSTRAINT pk_building PRIMARY KEY(building_name,ubication)"
            + ")";

    private static final String SQL_CREATE_SALON
            = "CREATE TABLE salon ("
            + "salon_name VARCHAR(45) NOT NULL,"
            + "capacity INTEGER NOT NULL,"
            + "in_use BOOLEAN NOT NULL,"
            + "observations TEXT NOT NULL,"
            + "building_name VARCHAR(45) NOT NULL,"
            + "building_ubication VARCHAR(45) NOT NULL,"
            + "CONSTRAINT pk_salon PRIMARY KEY(salon_name, building_name, building_ubication),"
            + "CONSTRAINT fk_building FOREIGN KEY(building_name, building_ubication) REFERENCES building(building_name, ubication)"
            + ")";

    private static final String SQL_CREATE_ACTIVITY
            = "CREATE TABLE activity ("
            + "activity_name VARCHAR(45) NOT NULL,"
            + "activity_code VARCHAR(45) NOT NULL,"
            + "start_time DATETIME NOT NULL,"
            + "end_time DATETIME NOT NULL,"
            + "salon_name VARCHAR(45) NOT NULL,"
            + "building_name VARCHAR(45) NOT NULL,"
            + "building_ubication VARCHAR(45) NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "activity_type ENUM('PRESENTATION','WORKSHOP') NOT NULL,"
            + "CONSTRAINT pk_activity PRIMARY KEY(activity_code),"
            + "CONSTRAINT fk_salon FOREIGN KEY(salon_name, building_name, building_ubication) REFERENCES salon(salon_name, building_name, building_ubication),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_WORKSHOP
            = "CREATE TABLE workshop ("
            + "conference_code VARCHAR(45) NOT NULL,"
            + "activity_code VARCHAR(45) NOT NULL,"
            + "maxim_limit INTEGER NOT NULL,"
            + "available_space INTEGER NOT NULL,"
            + "CONSTRAINT pk_workshop PRIMARY KEY(activity_code, conference_code),"
            + "CONSTRAINT fk_activity_code FOREIGN KEY(activity_code) REFERENCES activity(activity_code),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_PRESENTATION
            = "CREATE TABLE presentation ("
            + "conference_code VARCHAR(45) NOT NULL,"
            + "activity_code VARCHAR(45) NOT NULL,"
            + "topic VARCHAR(45) NOT NULL,"
            + "interested_users INTEGER NOT NULL,"
            + "CONSTRAINT pk_presentation PRIMARY KEY(activity_code, conference_code),"
            + "CONSTRAINT fk_activity_code FOREIGN KEY(activity_code) REFERENCES activity(activity_code),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_ATTENDEES
            = "CREATE TABLE attendees ("
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "activity_code VARCHAR(45) NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "is_foreign BOOLEAN NOT NULL,"
            + "CONSTRAINT pk_attendees PRIMARY KEY(user_dpi, activity_code, conference_code),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY(user_dpi) REFERENCES user(dpi),"
            + "CONSTRAINT fk_activity_code FOREIGN KEY(activity_code) REFERENCES activity(activity_code),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_ACTIVITIES_MANAGERS
            = "CREATE TABLE activities_managers ("
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "activity_code VARCHAR(45) NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "rol ENUM('SPEAKER','WORKSHOP LEADER') NOT NULL,"
            + "is_foreign BOOLEAN NOT NULL,"
            + "CONSTRAINT pk_activities_managers PRIMARY KEY(user_dpi, activity_code, conference_code),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY(user_dpi) REFERENCES user(dpi),"
            + "CONSTRAINT fk_activity_code FOREIGN KEY(activity_code) REFERENCES activity(activity_code),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_REGISTRATIONS
            = "CREATE TABLE registrations ("
            + "registration_date DATETIME NOT NULL,"
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "CONSTRAINT pk_registrations PRIMARY KEY(user_dpi, conference_code),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY(user_dpi) REFERENCES user(dpi),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_CONFERENCE_PAYMENTS
            = "CREATE TABLE conference_payments ("
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "payment_date DATETIME NOT NULL,"
            + "amount DECIMAL(10,2) NOT NULL,"
            + "wallet_name VARCHAR(45) NOT NULL,"
            + "wallet_bank VARCHAR(45) NOT NULL,"
            + "CONSTRAINT pk_conference_payments PRIMARY KEY(user_dpi, conference_code),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY(user_dpi) REFERENCES user(dpi),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code),"
            + "CONSTRAINT fk_wallet FOREIGN KEY(wallet_name, wallet_bank) REFERENCES wallet(wallet_name, bank_name)"
            + ")";

    private static final String SQL_CREATE_CONVOCATORY
            = "CREATE TABLE convocatory ("
            + "convocatory_code VARCHAR(45) NOT NULL,"
            + "description TEXT NOT NULL,"
            + "start_date DATETIME NOT NULL,"
            + "end_date DATETIME NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "CONSTRAINT pk_convocatory PRIMARY KEY(convocatory_code),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_SCIENCES_COMMITTEES
            = "CREATE TABLE sciences_committees ("
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "CONSTRAINT pk_sciences_committees PRIMARY KEY(user_dpi, conference_code),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY(user_dpi) REFERENCES user(dpi),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_PROPOSAL
            = "CREATE TABLE proposal ("
            + "proposal_code VARCHAR(45) NOT NULL,"
            + "title VARCHAR(45) NOT NULL,"
            + "description TEXT NOT NULL,"
            + "convocatory_code VARCHAR(45) NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "start_date DATETIME NOT NULL,"
            + "end_date DATETIME NOT NULL,"
            + "state ENUM('ACCEPTED','REJECTED','PENDING') NOT NULL,"
            + "CONSTRAINT pk_proposal PRIMARY KEY(proposal_code),"
            + "CONSTRAINT fk_convocatory_code FOREIGN KEY(convocatory_code) REFERENCES convocatory(convocatory_code),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY(user_dpi) REFERENCES user(dpi)"
            + ")";

    private static final String SQL_CREATE_RESERVER
            = "CREATE TABLE reserver ("
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "activity_code VARCHAR(45) NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "reservation_date DATETIME NOT NULL,"
            + "CONSTRAINT pk_reserver PRIMARY KEY(user_dpi, activity_code, conference_code),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY(user_dpi) REFERENCES user(dpi),"
            + "CONSTRAINT fk_activity_code FOREIGN KEY(activity_code) REFERENCES activity(activity_code),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_ASSISTANCE_CONTROL
            = "CREATE TABLE assistance_control ("
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "activity_code VARCHAR(45) NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "state ENUM('PENDING','ASSISTED','NOT ASSISTED') NOT NULL,"
            + "CONSTRAINT pk_assistance_control PRIMARY KEY(user_dpi, activity_code, conference_code),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY(user_dpi) REFERENCES user(dpi),"
            + "CONSTRAINT fk_activity_code FOREIGN KEY(activity_code) REFERENCES activity(activity_code),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_CERTIFICATES
            = "CREATE TABLE certificates ("
            + "certificate_code VARCHAR(45) NOT NULL,"
            + "description TEXT NOT NULL,"
            + "activity_code VARCHAR(45) NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "CONSTRAINT pk_certificate PRIMARY KEY(certificate_code),"
            + "CONSTRAINT fk_activity_code FOREIGN KEY(activity_code) REFERENCES activity(activity_code),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_PARTICIPATE_IN_ACTIVITY
            = "CREATE TABLE participate_in_activity ("
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "activity_code VARCHAR(45) NOT NULL,"
            + "conference_code VARCHAR(45) NOT NULL,"
            + "CONSTRAINT pk_participate_in_activity PRIMARY KEY(user_dpi, activity_code, conference_code),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY(user_dpi) REFERENCES user(dpi),"
            + "CONSTRAINT fk_activity_code FOREIGN KEY(activity_code) REFERENCES activity(activity_code),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY(conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_OWNED_CERTIFICATES
            = "CREATE TABLE owned_certificates ("
            + "conference_code VARCHAR(45) NOT NULL,"
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "activity_code VARCHAR(45) NOT NULL,"
            + "file BLOB NOT NULL,"
            + "CONSTRAINT pk_code PRIMARY KEY (activity_code, conference_code, user_dpi),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY (user_dpi) REFERENCES user(dpi),"
            + "CONSTRAINT fk_activity FOREIGN KEY (activity_code) REFERENCES activity(activity_code),"
            + "CONSTRAINT fk_conference_code FOREIGN KEY (conference_code) REFERENCES conference(conference_code)"
            + ")";

    private static final String SQL_CREATE_CONVOCATORIES_NOTIFICATIONS
            = "CREATE TABLE convocatories_notifications ("
            + "user_dpi VARCHAR(45) NOT NULL,"
            + "convocatory_code VARCHAR(45) NOT NULL,"
            + "description TEXT NOT NULL,"
            + "state BOOLEAN NOT NULL,"
            + "CONSTRAINT pk_convocatories_notifications PRIMARY KEY(user_dpi,convocatory_code),"
            + "CONSTRAINT fk_convocatory_code FOREIGN KEY(convocatory_code) REFERENCES convocatory(convocatory_code),"
            + "CONSTRAINT fk_user_dpi FOREIGN KEY(user_dpi) REFERENCES user(dpi)"
            + ")";

    /**
     * Método encargado de crear las tablas necesarias en la base de datos
     * verificando si alguna ya existe para no crearla y así optimizar el uso de
     * memoria y la velocidad del programa.
     */
    public void crearTablas() {
        try (Statement stmt = DBConnection.getInstance().getConnection().createStatement()) {
            if (!tableExists("system")) {
                stmt.executeUpdate(SQL_CREATE_SYSTEM);
            }
            if (!tableExists("institution")) {
                stmt.executeUpdate(SQL_CREATE_INSTITUTION);
            }
            if (!tableExists("user")) {
                stmt.executeUpdate(SQL_CREATE_USER);
            }
            if (!tableExists("wallet")) {
                stmt.executeUpdate(SQL_CREATE_WALLET);
            }
            if (!tableExists("system_admins")) {
                stmt.executeUpdate(SQL_CREATE_SYSTEM_ADMINS);
            }
            if (!tableExists("client")) {
                stmt.executeUpdate(SQL_CREATE_CLIENT);
            }
            if (!tableExists("conference")) {
                stmt.executeUpdate(SQL_CREATE_CONFERENCE);
            }
            if (!tableExists("conference_admins")) {
                stmt.executeUpdate(SQL_CREATE_CONFERENCE_ADMINS);
            }
            if (!tableExists("building")) {
                stmt.executeUpdate(SQL_CREATE_BUILDING);
            }
            if (!tableExists("salon")) {
                stmt.executeUpdate(SQL_CREATE_SALON);
            }
            if (!tableExists("activity")) {
                stmt.executeUpdate(SQL_CREATE_ACTIVITY);
            }
            if (!tableExists("workshop")) {
                stmt.executeUpdate(SQL_CREATE_WORKSHOP);
            }
            if (!tableExists("presentation")) {
                stmt.executeUpdate(SQL_CREATE_PRESENTATION);
            }
            if (!tableExists("attendees")) {
                stmt.executeUpdate(SQL_CREATE_ATTENDEES);
            }
            if (!tableExists("activities_managers")) {
                stmt.executeUpdate(SQL_CREATE_ACTIVITIES_MANAGERS);
            }
            if (!tableExists("registrations")) {
                stmt.executeUpdate(SQL_CREATE_REGISTRATIONS);
            }
            if (!tableExists("conference_payments")) {
                stmt.executeUpdate(SQL_CREATE_CONFERENCE_PAYMENTS);
            }
            if (!tableExists("convocatory")) {
                stmt.executeUpdate(SQL_CREATE_CONVOCATORY);
            }
            if (!tableExists("sciences_committees")) {
                stmt.executeUpdate(SQL_CREATE_SCIENCES_COMMITTEES);
            }
            if (!tableExists("proposal")) {
                stmt.executeUpdate(SQL_CREATE_PROPOSAL);
            }
            if (!tableExists("reserver")) {
                stmt.executeUpdate(SQL_CREATE_RESERVER);
            }
            if (!tableExists("assistance_control")) {
                stmt.executeUpdate(SQL_CREATE_ASSISTANCE_CONTROL);
            }
            if (!tableExists("certificates")) {
                stmt.executeUpdate(SQL_CREATE_CERTIFICATES);
            }
            if (!tableExists("participate_in_activity")) {
                stmt.executeUpdate(SQL_CREATE_PARTICIPATE_IN_ACTIVITY);
            }
            if (!tableExists("owned_certificates")) {
                stmt.executeUpdate(SQL_CREATE_OWNED_CERTIFICATES);
            }
            if (!tableExists("convocatories_notifications")) {
                stmt.executeUpdate(SQL_CREATE_CONVOCATORIES_NOTIFICATIONS);
            }
            System.out.println("Se han creado las tablasó");
        } catch (SQLException e) {
            System.out.println("Ha ocurrido una exception del tipo " + e.getClass().getName() + " al realizar la creación de tablas en la DB porque " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Método encargado de verificar si existe una tabla en la DB
     *
     * @param nombreTabla nombre de la tabla a verificar
     * @return true si existe
     */
    public boolean tableExists(String nombreTabla) {
        try (ResultSet resultSet = DBConnection.getInstance().getConnection().getMetaData().getTables(null, null, nombreTabla, null);) {
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Ha ocurrido un error al intentar averiguar si existe la tabla " + nombreTabla);
            return false;
        }
    }

}
