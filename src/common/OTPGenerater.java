package common;

import java.util.Random;

public class OTPGenerater {

    public String generatesOtp() {
        // Generate a random 6-digit OTP
        Random random = new Random();
         String OTPValue = String.valueOf(100_000 + random.nextInt(900_000));
        return OTPValue;
    }

}
