package banco;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaEspecial;
import contas.ContaPoupanca;

public class Banco {

	private static int count = 0;

	public static void main(String[] args) {

		ArrayList<Conta> lista = new ArrayList<Conta>();

		String menu = "Bem Vindo ao banco!\n\n 1-Criar Conta.\n 2-Visualizar Conta.\n 3-Depositar.\n 4-Sacar.\n 5-Transferir\n 6-Atualizar Cadastro\n 0-Sair.";
		String menu2 = "Escolha  o tipo da conta: \n1-Conta Corrente. \n2-Conta Poupança. \n3-Conta Especial.";
		int op = -1;

		do {
			op = getOption(menu);

			switch (op) {
			case 1:
				op = getOption(menu2);

				switch (op) {
				case 1:
					criarContaCorrente(lista);
					break;

				case 2:
					criarPoupanca(lista);
					break;

				case 3:
					criarContaEspecial(lista);
					break;

				default:
					JOptionPane.showMessageDialog(null, "Digite uma opção válida!");
					break;
				}
				break;

			case 2:
				op = visualizarContas(lista);
				break;

			case 3:
				op = depositar(lista);
				break;

			case 4:
				op = sacar(lista);
				break;

			case 5:
				op = transferir(lista);
				break;

			case 6:
				op = atualizarCadastro(lista);
				break;

			case 0:
				JOptionPane.showMessageDialog(null, "Obrigado Pela Preferencia.");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida!");
				break;
			}

		} while (op != 0);
	}

	private static int atualizarCadastro(ArrayList<Conta> lista) {
		int op = -1;
		try {
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta"));
			int pass = Integer.parseInt(JOptionPane.showInputDialog("Digite sua senha"));

			Conta c1 = lista.get(op - 1);
			if (pass == c1.getSenha()) {
				c1.getNome();
				c1.setNome(JOptionPane.showInputDialog("Digite o novo nome de titular"));
			} else {
				JOptionPane.showMessageDialog(null, "Senha  incorreta");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Não é permitido letras, digite apenas números.");
		} catch (IndexOutOfBoundsException i) {
			JOptionPane.showMessageDialog(null, "Número de conta não encontrado.");
		}
		return op;
	}

	private static int transferir(ArrayList<Conta> lista) {
		int op = -1;
		try {
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta de origem"));
			int pass = Integer.parseInt(JOptionPane.showInputDialog("Digite sua senha"));

			Conta c3 = lista.get(op - 1);

			if (pass == c3.getSenha()) {
				int valTransf = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor para transferência"));

				int contDestino = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta de destino."));
				Conta c4 = lista.get(contDestino - 1);

				c3.tranferir(c4, valTransf);
			} else {
				JOptionPane.showMessageDialog(null, "Senha  incorreta");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Não é permitido letras, digite apenas números.");
		} catch (IndexOutOfBoundsException i) {
			JOptionPane.showMessageDialog(null, "Número de conta não encontrado.");
		}
		return op;
	}

	private static int sacar(ArrayList<Conta> lista) {
		int op = -1;
		try {
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta."));
			int pass = Integer.parseInt(JOptionPane.showInputDialog("Digite sua senha"));

			Conta c1 = lista.get(op - 1);
			if (pass == c1.getSenha()) {
				c1.sacar(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para saque")));
			} else {
				JOptionPane.showMessageDialog(null, "Senha Incorreta!");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Não é permitido letras, digite apenas números.");
		} catch (IndexOutOfBoundsException i) {
			JOptionPane.showMessageDialog(null, "Número de conta não encontrado.");
		}
		return op;
	}

	private static int depositar(ArrayList<Conta> lista) {
		int op = -1;
		try {
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta"));
			int pass = Integer.parseInt(JOptionPane.showInputDialog("Digite sua senha"));

			Conta c1 = lista.get(op - 1);
			if (pass == c1.getSenha()) {
				c1.depositar(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para depósito.")));
			} else {
				JOptionPane.showMessageDialog(null, "Senha Incorreta!");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Não é permitido letras, digite apenas números.");
		} catch (IndexOutOfBoundsException i) {
			JOptionPane.showMessageDialog(null, "Número de conta não encontrado.");
		}
		return op;
	}

	private static int visualizarContas(ArrayList<Conta> lista) {
		int op = -1;
		try {
			op = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta"));
			int pass = Integer.parseInt(JOptionPane.showInputDialog("Digite sua senha"));

			Conta c1 = lista.get(op - 1);
			if (pass == c1.getSenha()) {
				JOptionPane.showMessageDialog(null, lista.get(op - 1));
			} else {
				JOptionPane.showMessageDialog(null, "Senha Incorreta!");

			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Não é permitido letras, digite apenas números.");
		} catch (IndexOutOfBoundsException i) {
			JOptionPane.showMessageDialog(null, "Número de conta não encontrado.");
		}
		return op;
	}

	private static void criarContaEspecial(ArrayList<Conta> lista) {
		ContaEspecial ce = new ContaEspecial();
		ce.setNumConta(++count);
		String nome = JOptionPane.showInputDialog("Digite seu nome: ").toUpperCase();

		if (nome.matches("[A-Z]+[^0-9]+")) {
			ce.setNome(nome);

			try {
				ce.setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de deposito: ")));
				ce.setSenha(Integer.parseInt(JOptionPane.showInputDialog("Digite uma senha: ")));
				ce.setLimiteExtra(5000);
				lista.add(ce);
				JOptionPane.showMessageDialog(null, "Conta criada com sucesso!\n" + ce);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Não é permitido letras, digite apenas números.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Digite um nome válido! \nSem números.");
		}
	}

	private static void criarPoupanca(ArrayList<Conta> lista) {

		ContaPoupanca cp = new ContaPoupanca();
		cp.setNumConta(++count);
		String nome = JOptionPane.showInputDialog("Digite seu nome: ").toUpperCase();

		if (nome.matches("[A-Z]+[^0-9]+")) {
			cp.setNome(nome);

			try {
				cp.setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de deposito: ")));
				cp.setSenha(Integer.parseInt(JOptionPane.showInputDialog("Digite uma senha: ")));
				lista.add(cp);
				JOptionPane.showMessageDialog(null, "Conta criada com sucesso!\n" + cp);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Não é permitido letras, digite apenas números.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Digite um nome válido! \nSem números.");
		}

	}

	private static void criarContaCorrente(ArrayList<Conta> lista) {
		ContaCorrente cc = new ContaCorrente();
		cc.setNumConta(++count);
		String nome = JOptionPane.showInputDialog("Digite seu nome: ").toUpperCase();

		if (nome.matches("[A-Z]+[^0-9]+")) {
			cc.setNome(nome);

			try {
				cc.setSaldo(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de deposito: ")));
				cc.setSenha(Integer.parseInt(JOptionPane.showInputDialog("Digite uma senha: ")));
				lista.add(cc);
				JOptionPane.showMessageDialog(null, "Conta criada com sucesso!\n" + cc);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Não é permitido letras, digite apenas números.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Digite um nome válido! \nSem números.");
		}
	}

	private static int getOption(String menu) {
		int op = 0;
		try {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		} catch (NumberFormatException e) {
			op = -1;
		}

		return op;
	}
}
