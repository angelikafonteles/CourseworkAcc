package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import entities.PcdVehicle;
import entities.StandardVehicle;
import entities.Vehicle;
import entities.enums.VehicleType;
import entities.exceptions.DomainException;
import services.IPIService;
import services.LoanService;
import services.SaleService;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Contract contract  = new Contract();
		Vehicle vehicle = new Vehicle();
		LoanService loan = new LoanService();
		
		try {
			System.out.println("DIGITE OS DADOS DO VEICULO");
			System.out.print("Modelo: ");
			String model = sc.next();
			System.out.print("Tipo (Padrao/ PCD): ");
			sc.nextLine();
			VehicleType type = VehicleType.valueOf(sc.nextLine().toUpperCase());
			System.out.print("Valor inicial: ");
			double price = sc.nextDouble();
			System.out.println();
			
			System.out.println("DADOS DO CLIENTE");
			System.out.print("Nome: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Deseja financiar (S/ N)? ");
			char resp = sc.nextLine().toUpperCase().charAt(0);
			
			if(type.ordinal() == 0) {
				
				vehicle = new StandardVehicle(model, type, price, new SaleService(new IPIService()));
				StandardVehicle standard = (StandardVehicle)vehicle;
				standard.updatePrice(price);
				Double amount = standard.getPrice();
				if(resp == 'S') {
					System.out.print("Data (dd/MM/aaaa): ");
					Date date = sdf.parse(sc.next());
					contract = new Contract(date, amount);
					System.out.print("Digite o número de parcelas: ");
					int months = sc.nextInt();
					loan.processLoan(contract, months);
				}
				if(resp == 'N') {
					vehicle.ProcessDiscount(amount);
				}
			}
			else if(type.ordinal() == 1) {
				vehicle = new PcdVehicle(model, type, price);
				PcdVehicle pcd = (PcdVehicle)vehicle;
				Double amount = pcd.getPrice();
				if(resp == 'S') {
					System.out.print("Data (dd/mm/aaaa): ");
					Date date = sdf.parse(sc.next());
					contract = new Contract(date, amount);
					System.out.print("Digite o número de parcelas: ");
					int months = sc.nextInt();
					loan.processLoan(contract, months);
				}
				if(resp == 'N'){
					vehicle.ProcessDiscount(amount);
				}
			}
			System.out.println();
			System.out.println("DADOS DA VENDA");
			System.out.println("Nome: " + name);
			System.out.println(vehicle);
			
			System.out.println();
			if(resp == 'S') {
				System.out.println("DADOS DO FINANCIAMENTO:");
				for(Installment x : contract.getInstallments()) {
					System.out.println(x);
				}
			}
		}
		catch(DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}

}
