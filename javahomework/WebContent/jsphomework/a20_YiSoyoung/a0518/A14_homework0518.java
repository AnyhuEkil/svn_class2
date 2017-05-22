package javaexp.a13_stream;
/* 1�ܰ� : �Ʒ��� �����͸� prodData.dat�� �����ϰ� ȣ��
		���Ǹ�	����		����
		���		3000	2
		�ٳ���	4000	2
		��		6000	3
 * 2�ܰ� : Scanner Ŭ������ Ȱ���Ͽ� ���� ���� �����͸� �Է��Ͽ� ������ ���Ͽ� ����, ����� ������ �����͸� �ҷ� ����Ʈ�ϴ� ó��.
 * */
import java.io.*;
import java.util.Scanner;
public class A14_homework0518 {
	public static void main(String[] args) {
		String dataFile = "C:/a01_prog/prodData.dat";
		OutputStream fos = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		DataInputStream dis = null;
		Scanner scanner = new Scanner(System.in);
		try{
			fos = new FileOutputStream(dataFile, false);
			dos = new DataOutputStream(fos);
			for(int i=0 ; i<3 ; i++){
				System.out.print("���Ǹ� : ");
				dos.writeUTF(scanner.next());
				System.out.print("���� : ");
				dos.writeInt(scanner.nextInt());
				System.out.print("���� : ");
				dos.writeInt(scanner.nextInt());
			}
			System.out.println("�̻� ���� �Է� ��. �Ʒ��� �Էµ� ������ ����Ѵ�");
			fis = new FileInputStream(dataFile);
			dis = new DataInputStream(fis);
			String pName; int price; int ps;
			System.out.println("���Ǹ�\t����\t����");
			System.out.println("�����������������������������");
			for(int i=0 ; i<3 ; i++){
				pName = dis.readUTF();
				price = dis.readInt();
				ps = dis.readInt();
				System.out.println(pName+"\t"+price+"\t"+ps);
			}
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try{
				if(dis!=null){ dis.close(); }
				if(fis!=null){ fis.close(); }
				if(dos!=null){ dos.flush(); dos.close(); }
				if(fos!=null){ fos.flush(); fos.close(); }
			}catch (Exception ignore) { }
		}
		scanner.close();
	}
}
