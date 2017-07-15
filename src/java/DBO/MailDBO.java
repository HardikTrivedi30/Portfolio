package DBO;

public class MailDBO {

    private String messageBody;

    private String name;

    private String phone;

    private String email;

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        String result;
        result = name + " : " + messageBody + " : "
                + email + " : " + phone;
        return result;
    }

}
