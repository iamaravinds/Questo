package com.avin.questo.utility;

import com.avin.questo.service.QuestoServiceImpl;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Encrypt {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(QuestoServiceImpl.class);
    private MessageDigest md;

    public  String cryptWithMD5(String pass) {
        logger.info("Into cryptoMD5");
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < digested.length; i++) {
                sb.append(Integer.toHexString(0xff & digested[i]));

            }
            logger.info(sb.toString());
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;


    }
}