package Selectors.Deals;

public class FORM_Offer {
    static public String FIELD_Offer_Amount = "//*[@placeholder='Offer Amount']";
    static public String FIELD_EMD_Amount = "//*[@placeholder='EMD Amount']";
    static public String FIELD_Buyer_Company = "//*[@placeholder='Buyer Company']";
    static public String BUTTON_Make_an_Offer = "//*[@class='button fullwidth btn-block']";
    static public String TEXT_Almost_there = "//*[contains(text(),'Almost there')]";
    static public String BUTTON_Upload_Proof_of_Funds = "//*[@for='proof_file']";
    static public String BUTTON_Confirm_Proof_of_Funds = "//div/a[contains(text(),'Upload Proof')]";
    static public String INPUT = "//input[@type='file']";
    static public String TEXT_You_have_successfully_uploaded = "//*[contains(text(),'You have successfully uploaded The Proof of Funds')]";
    static public String TEXT_Your_offer_has_been_submitted = "//*[contains(text(),'Your offer has been submitted')]";
    static public String BUTTON_Confirm = "//*[contains(text(),'Confirm')]";
    static public String BUTTON_Close = "//a[contains(text(),'Close')]";
    static public String BUTTON_Sign_the_Purchase_Contract_Online = "//*[contains(text(), 'Sign the Purchase Contract Online')]";
    static public String BUTTON_Finish_signature_process = "(//a[@href='#'])[4]";
}
