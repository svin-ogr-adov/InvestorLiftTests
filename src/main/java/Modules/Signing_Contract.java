package Modules;

import static Potroha.Docusign_Frame_Switcher.docusign_frame_detector;
import static Potroha.Web_Element.elem;
import static Potroha.Web_Element.elem_wait;
import static Potroha.Web_Element.elems;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Mail.Sent_Event;
import Potroha.Collector;
import Potroha.Collector.State;
import Potroha.Docusign_Frame_Switcher;
import Potroha.Driver;
import Potroha.Wait;
import Selectors.Deals.FORM_Docu_Sign;

public class Signing_Contract {
	public enum place {
		on_stage,
		on_deals
	}

    public static void signing_contract(place location) throws InterruptedException {

        int fr = docusign_frame_detector(FORM_Docu_Sign.BUTTON_Continue, FORM_Docu_Sign.CHECKBOX_I_Agree);
        System.out.println("Current frame: " + fr);

        try {
            try {
                Wait.off_implicit_wait();
                elem(FORM_Docu_Sign.CHECKBOX_I_Agree).click();
                Wait.on_implicit_wait();
            } catch (Exception ignored) {}
            elem_wait(FORM_Docu_Sign.BUTTON_Continue, 200, 60).click();
            List<WebElement> signs =  elems(FORM_Docu_Sign.BUTTON_Sign);
            for (WebElement sign : signs) {
                try {
                    sign.click();
                    Thread.sleep(1000);
                    Wait.off_implicit_wait();

                    System.out.println(Driver.driver.findElements(By.id("iframe")).size());
//                    int fr2 = docusign_frame_detector(FORM_Docu_Sign.BUTTON_Adopt_and_Sign);
//                    if (fr != fr2) {
                    //docusign_frame_detector(FORM_Docu_Sign.BUTTON_Adopt_and_Sign);
                    	elem(FORM_Docu_Sign.BUTTON_Adopt_and_Sign).click();
                    //	docusign_frame_detector(FORM_Docu_Sign.BUTTON_Adopt_and_Initial);
                    	elem(FORM_Docu_Sign.BUTTON_Adopt_and_Initial).click();
  //                  }

                    Wait.on_implicit_wait();
                    System.out.println(Docusign_Frame_Switcher.frames_calculator());
                } catch (Exception ignored) {}
            }
            Thread.sleep(2000);
            elem_wait(FORM_Docu_Sign.BUTTON_Finish, 200, 60).click();
            if (location == place.on_stage) {
            	Collector.add_event(new Sent_Event("Contract Signed", " "+location.name()));
                Collector.add_event(new Sent_Event("Completed Docusign", " "+location.name()));
            }

            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName()+" "+location.name(), State.ok);
        } catch (Exception e) {
            Collector.add_event(new Throwable().getStackTrace()[0].getMethodName()+" "+location.name(), State.fail);
            Collector.add_event(e.getMessage(), State.exception);
        }
    }
}
