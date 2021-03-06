package notifications;

import exerciseCreator.executor.Outcome;

import java.io.*;
import java.util.Properties;

public class InstructorConfiguration {
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private Properties prop = new Properties();
    private String mail = null;
    private String number = null;
    private String name = null;
    private String lastname = null;


    private String fetchProperty(String propName) {
        String propVal = null;
        try{
            inputStream = new FileInputStream("src/main/resources/config.properties");
            prop.load(inputStream);
            propVal = prop.getProperty(propName);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return propVal;
    }


    public String getMail() {
        if(this.mail == null) {
            this.mail = fetchProperty("usermail");
        }
        return this.mail;
    }

    public String getNumber() {
        if(this.number == null) {
            this.number = fetchProperty("userphone");
        }
        return this.number;
    }

    public String getName() {
        if(this.name == null) {
            this.name = fetchProperty("username");
        }
        return this.name;
    }

    public String getLastName() {
        if(this.lastname == null) {
            this.lastname = fetchProperty("userlastname");
        }
        return this.lastname;
    }

    public void setMail(String mail) {
        try{
            outputStream = new FileOutputStream("config.properties");
            prop.setProperty("usermail", mail);
            prop.store(outputStream, null);
            this.mail = mail;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Outcome getInstructorOutcome(Outcome outcomeSource) {
        Outcome outcome = new Outcome(outcomeSource);
        outcome.setPhoneNumber(getNumber());
        outcome.setEmail(getMail());
        return outcome;
    }
}
