import java.util.Random;

public class Test {
	public static void main(String[] args) {
        // 1���� 100������ �������� ��ȣ ����
//        for (int i = 1; i <= 100; i++) {
//            // ������ ��ȣ�� ���� if������ ������ ����
//            int adminNumber = (i % 4) + 1; // 1���� 4������ �������� ��ȣ ����
//            assignAdmin(i, adminNumber);
//        }
		
		String virtualAccount = generateVirtualAccount();
        System.out.println("������ �������: " + virtualAccount);
    }

    private static void assignAdmin(int userNumber, int adminNumber) {
        // ��ȣ�� ���� if������ ������ ����
        if (adminNumber == 1) {
            System.out.println(userNumber + "�� ����ڴ� 1�� �����ڿ��� �����˴ϴ�.");
            // 1�� �����ڿ��� �Ҵ��� �۾� ����
        } else if (adminNumber == 2) {
            System.out.println(userNumber + "�� ����ڴ� 2�� �����ڿ��� �����˴ϴ�.");
            // 2�� �����ڿ��� �Ҵ��� �۾� ����
        } else if (adminNumber == 3) {
            System.out.println(userNumber + "�� ����ڴ� 3�� �����ڿ��� �����˴ϴ�.");
            // 3�� �����ڿ��� �Ҵ��� �۾� ����
        } else if (adminNumber == 4) {
            System.out.println(userNumber + "�� ����ڴ� 4�� �����ڿ��� �����˴ϴ�.");
            // 4�� �����ڿ��� �Ҵ��� �۾� ����
        } else {
            System.out.println("���� ó�� �Ǵ� �⺻ ���� ����");
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
