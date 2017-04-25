/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import static javax.servlet.jsp.tagext.Tag.SKIP_BODY;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author nh228u24
 */
public class phoneConverter extends TagSupport{
    
    /**
     * The incoming unformatted cell phone number
     */
    private String incomingNumber = "";
    
    /**
     * The cell phone number after being formatted
     */
    private String formattedNumber = "";

    /**
     * The incoming unformatted cell phone number
     * @param incomingNumber the incomingNumber to set
     */
    public void setIncomingNumber(String incomingNumber) {
        this.incomingNumber = incomingNumber;
    }
    
    @Override
    public int doStartTag() throws JspException {
        format();
        try {
            JspWriter out = pageContext.getOut();
            out.print(formattedNumber);
        } catch (IOException ioe) {
            
        }

        return SKIP_BODY;
    }

    private void format() {
        
        //Remove trailing and ending whitespace just in case
        setIncomingNumber(incomingNumber.trim());
        
        // Make sure string contains only numbers
        if(incomingNumber.matches("[0-9]+") == false){
            
            formattedNumber = incomingNumber;
  
        }else{ // Number does not contain letters
            
            if(incomingNumber.length() == 10 ){ // If the number contains the area code
            
                formattedNumber = "(" + incomingNumber.substring(0, 3) + ") " + incomingNumber.substring(3, 6) + "-" + incomingNumber.substring(6);
        
            }else if(incomingNumber.length() == 7){ // If the number does not conatin the are code
            
                formattedNumber = "() " + incomingNumber.substring(0, 3) + "-" + incomingNumber.substring(3);
            
            }else{ // Too many or too few digits.
                formattedNumber = incomingNumber;
            }
        }

    }
    
    
}
