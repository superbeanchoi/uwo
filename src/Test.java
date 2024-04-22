import java.util.Random;

public class Test {
	public static void main(String[] args) {
        // 1부터 100까지의 순차적인 번호 생성
//        for (int i = 1; i <= 100; i++) {
//            // 생성된 번호에 따라서 if문으로 관리자 배정
//            int adminNumber = (i % 4) + 1; // 1부터 4까지의 순차적인 번호 생성
//            assignAdmin(i, adminNumber);
//        }
		
		String virtualAccount = generateVirtualAccount();
        System.out.println("생성된 가상계좌: " + virtualAccount);
    }

    private static void assignAdmin(int userNumber, int adminNumber) {
        // 번호에 따라서 if문으로 관리자 배정
        if (adminNumber == 1) {
            System.out.println(userNumber + "번 사용자는 1번 관리자에게 배정됩니다.");
            // 1번 관리자에게 할당할 작업 수행
        } else if (adminNumber == 2) {
            System.out.println(userNumber + "번 사용자는 2번 관리자에게 배정됩니다.");
            // 2번 관리자에게 할당할 작업 수행
        } else if (adminNumber == 3) {
            System.out.println(userNumber + "번 사용자는 3번 관리자에게 배정됩니다.");
            // 3번 관리자에게 할당할 작업 수행
        } else if (adminNumber == 4) {
            System.out.println(userNumber + "번 사용자는 4번 관리자에게 배정됩니다.");
            // 4번 관리자에게 할당할 작업 수행
        } else {
            System.out.println("예외 처리 또는 기본 동작 설정");
        }
    }
    
    private static String generateVirtualAccount() {
        Random random = new Random();
        int AAASection = random.nextInt(900) + 100;
        int BBBBSection = random.nextInt(9000) + 1000;
        int CCCSection = random.nextInt(900) + 100;
        String virtualAccount = String.format("%03d-%04d-%04d-%03d", AAASection, BBBBSection, BBBBSection, CCCSection);
        return virtualAccount;
    }
}
