package PageObjectRepository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_LoginScenario {
//	WebDriver driver;

	@FindBy (linkText= "Sign In")
	WebElement link_SignIn;
	
	@FindBy (name= "logid")
	WebElement text_username;
	
	@FindBy (name= "pswd")
	WebElement text_pwd;
	
	@FindBy (css = "input[value='Login']")
	WebElement Button_LoginBtn;
	
	@FindBy (xpath = "//b[contains(text(),'Sorry we were unable to complete this step because :')]")
	WebElement text_Invalidmsg;
	
	@FindBy (css = "span[id = 'username'] a")
	WebElement text_validmsg;
	
	@FindBy (linkText = "Sign Out")
	WebElement link_Signout;
	
	
	public POM_LoginScenario (WebDriver driver)
	{
//		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	

	public void click_SignIn()
	{
		link_SignIn.click();
	}
	
	public void Entertext_Username(String Uname)
	{
		text_username.sendKeys(Uname);
	}
	
	public void Entertext_Pwd(String Pwd)
	{
		text_pwd.sendKeys(Pwd);
	}
	
	public void click_loginbutton()
	{
		Button_LoginBtn.click();
	}
	
	public String  get_invalid_log_msg()
	{
		return text_Invalidmsg.getText();
	}
	
	public String  get_valid_log_msg()
	{
		return text_validmsg.getText();
	}
	public void click_signout()
	{
		link_Signout.click();
	}
	
	public void execute_common_methods_log(String Uname , String Pwd)
	{
		click_SignIn();
		 Entertext_Username( Uname);
		 Entertext_Pwd( Pwd);
		 click_loginbutton();
	}
	
	

}
