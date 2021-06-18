package presenters;

import coursex.CoursexUI;
import views.SignInView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignInPresenter {
    public SignInView SignInView ;
    public CoursexUI CoursexUI;

    public SignInPresenter( SignInView SignInView)
    {
        this.SignInView=SignInView;
        showSignUpView();
        emailValidation();
        passwordValidation();
    }
    private void showSignUpView()
    {
        this.SignInView.signUpBtn.setOnAction(action->{
            this.CoursexUI.window.getScene().setRoot(CoursexUI.SignUpView);
        });
    }
    private void emailValidation() {
        this.SignInView.emailFld.setOnKeyPressed(e -> {
            if (isValidEmail(this.SignInView.emailFld.getText()) ||(this.SignInView.emailFld.getText()==""))
                this.SignInView.emailValidate.setVisible(false);
            else
                this.SignInView.emailValidate.setVisible(true);
        });
    }
    private void passwordValidation(){
        this.SignInView.passwordFld.setOnKeyPressed(e -> {
            if(isValidPassword(this.SignInView.passwordFld.getText()))
                this.SignInView.passwordValidate.setVisible(false);
            else
                this.SignInView.passwordValidate.setVisible(true);
        });
    }
    public boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public boolean isValidPassword(String password){
        if (password.length()<7)
            return false;
        return true;
    }
}

