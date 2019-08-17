public class Solution165 {
    public int compareVersion(String version1, String version2) {
        String ver1[] = version1.split("\\.");
        String ver2[] = version2.split("\\.");
        int len = Math.min(ver1.length, ver2.length);
        for (int i = 0; i < len; i++) {
            int num1 = Integer.parseInt(ver1[i]), num2 = Integer.parseInt(ver2[i]);
            if (num1 != num2) {
                return num1 > num2 ? 1 : -1;
            }
        }
        if(ver1.length>ver2.length){
            for(int i=len;i<ver1.length;i++){
                if (Integer.parseInt(ver1[i])!=0)
                    return 1;
            }
        }
        if(ver1.length<ver2.length){
            for(int i=len;i<ver2.length;i++){
                if(Integer.parseInt(ver2[i])!=0)
                    return -1;
            }
        }
        return 0;
    }
}
