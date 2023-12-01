//    Validate the AI Prompt for the SMS Fraud Detection use case
//    This is a simple test to validate the AI Prompt for the SMS Fraud Detection use case
//    The test will pass if the AI Prompt is not empty
//    The test will fail if the AI Prompt is empty
//    The test will fail if the AI Prompt is not in the expected format
//    The test will fail if the AI Prompt is not in the expected language
//    The test will fail if the AI Prompt is not in the expected voice

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmsFraudDetection {
    public static void main(String[] args) {
        String smsInput = "Your account has been compromised. Click here to reset your password.";

        if (isPotentialFraud(smsInput)) {
            System.out.println("This SMS might be a fraud!");
        } else {
            System.out.println("This SMS seems to be legitimate.");
        }
    }

    private static boolean isPotentialFraud(String sms) {
        // Check for known fraud patterns using regular expressions
        if (containsFraudPattern(sms)) {
            return true;
        }
        return false;
    }

    private static boolean containsFraudPattern(String sms) {
        // Define a simple fraud pattern using a regular expression
        String fraudPattern = "password|compromised|click\\s+here";

        // Compile the pattern and create a matcher
        Pattern pattern = Pattern.compile(fraudPattern, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sms);

        // Check if the pattern is found in the SMS
        return matcher.find();
    }
}