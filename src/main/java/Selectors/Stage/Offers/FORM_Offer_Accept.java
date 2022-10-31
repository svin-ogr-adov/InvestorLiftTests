package Selectors.Stage.Offers;

public class FORM_Offer_Accept {
    static public String TEXT_Specify_Settlement_Date_for_this_offer = "//*[contains(text(),'Specify Settlement Date for this offer')]";
    static public String TEXT_Specify_Title_Company = "//*[contains(text(),'Specify Title Company')]";
    static public String TEXT_Specify_Additional_Contract_Addendums = "//*[contains(text(),'Specify Additional Contract Addendums')]";
    static public String TEXT_Additional_Details = "//*[contains(text(),'Additional Details')]";
    static public String BUTTON_Set_and_Accept_Offer = "//*[contains(text(),'Set and Accept Offer')]";
    static public String BUTTON_Cancel = "//*[contains(text(),'Cancel')]";
    static public String FIELD_Date = "//*[@type='text']";
    static public String LIST_ITEM_Company_Kelleher_and_Sadowsky = "//*[contains(text(),'Kelleher & Sadowsky')]";
    static public String FIELD_Addendums = "//*[contains(text(),'Addendums')]/following-sibling::node()[2]";
    static public String LIST_Company = "(//*[@class='form-control'])[2]";
    static public String BUTTON_Ok = "//*[contains(text(),'Ok')]";
}
