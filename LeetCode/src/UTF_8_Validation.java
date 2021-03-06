/**
 * LeetCode
 * 393. UTF-8 Validation
 * @author lorreina
 *
 */
public class UTF_8_Validation {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return true;
        }
        
        for (int i = 0; i < data.length; i++) {
            int nByte = findByte(data[i]);
            if (nByte == 1) {
                return false;
            }
            if (i + nByte > data.length) {
                return false;
            }
            for (int j = 0; j < (nByte - 1); j++) {
                i += 1;
                if (!isValid(data[i])) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private int findByte(int num) {
        int nByte = 0;
        int data = num & 0xFF;
        int flag = 0x80;
        if ((data & flag) == 0) {
            return 0;
        }
        
        while (flag != 0) {
            if ((flag & num) == 0){
                break;
            }
            nByte++;
            flag = flag >> 1;
        }
        
        return nByte;
    }
    
    private boolean isValid(int num) {
        if ((num & 0x80) != 0 && (num & 0x40) == 0) {
            return true;
        }
        
        return false;
    }
}
