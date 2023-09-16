public class BasicSpamCheck {
    public static void main(String[] args) {
        String message = "Check out our amazing offers! Buy now and get rich quick!";

        if (isSpam(message)) {
            System.out.println("This message appears to be spam.");
        } else {
            System.out.println("This message is not spam.");
        }
    }

    public static boolean isSpam(String message) {
        // Define a list of spam keywords or phrases
        String[] spamKeywords = {"buy now", "get rich quick", "limited time offer"};

        // Convert the message to lowercase for case-insensitive matching
        message = message.toLowerCase();

        // Check if the message contains any spam keywords
        for (String keyword : spamKeywords) {
            if (message.contains(keyword)) {
                return true;
            }
        }

        return false;
    }
}
