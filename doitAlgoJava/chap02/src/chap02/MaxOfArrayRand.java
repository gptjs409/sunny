package chap02;

// Random ���� Import
import java.util.Random;
import java.util.Scanner;

// �迭 ����� �ִ��� ��Ÿ��(���� ������ ����)
public class MaxOfArrayRand {
	
	public static void main(String[] args) {
		
		// Random ��� ����
		Random rand = new Random();
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("Ű�� �ִ��� ���մϴ�.");
		System.out.print("��� �� : ");
		int num = stdIn.nextInt(); // �迭�� ��Ҽ�
		stdIn.close();
		
		int[] height = new int[num]; // ��Ҽ��� num�� �迭 ����
		
		System.out.println("Ű ���� �Ʒ��� �����ϴ�.");
		for (int i = 0; i < num; i++) {
			// rand.nextInt(n) �� ������ �����ϴ� �޼���, 0 ~ n - 1������ ������ ��ȯ
			height[i] = 100 + rand.nextInt(90); // ����� ���� ������ ����
			System.out.println("height[" + i + "] : " + height[i]);
		}
		
		System.out.println("�ִ��� " + maxOf(height) + "�Դϴ�.");
	}

	// �迭 a�� �ִ��� ���Ͽ� ��ȯ
	static int maxOf(int [] a) {
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (a[i] > max)
				max = a[i];
		return max;
	}
}

/* 
 * Random Ŭ������ �ν��Ͻ��� �Ϸ��� �ǻ� ������ ����
 *     > �ǻ� ���� : �ǻ� = ������ �����, ��¥ ������ �ƴ�����(�ζ� ��ȣ �̵�), �׿� ����ϰ� ó��
 *     > seed ���� ��ǻ�� ȯ���� ���ٸ�, ��� ���� �׻� ����
 *     > ���� seed ���� ��ġ�� �ʰ� �ϱ� ���� ���� �ð��� �̿��ϴ� ���� �Ϲ���
 * ������ seed(����)�̶�� ���� ���� �������� ���� ������ �����Ͽ� ����
 * Random Ŭ���������� 48��Ʈ�� seed�� ���, �� seed�� ���� �յ����̶�� ������ ���� Ư�� ��(����)�� �ٲ�
 * Random random = new Random();
 *     > ���� �����⸦ ���� ����, Random Ŭ������ �ٸ� �ν��Ͻ��� ��ġ�� �ʵ��� seed ���� �ڵ� ����
 * Random random = new Random(n);
 *     > ���� �����⸦ ���� �����, seed���� n���� ����
 */