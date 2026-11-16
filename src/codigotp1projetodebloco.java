
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class codigotp1projetodebloco {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema VidaPet - Prototipo Inicial (TP1) ===");
        
        // Simulação de cadastro rápido de dados primitivos para teste de regras
        String nomeAnimal = "Thor";
        String especieAnimal = "Cão";
        int idadeAnimal = 3;
        String nomeTutor = "Carlos Silva";
        String telefoneTutor = "(35) 99888-7766";

        String nomeVeterinario = "Dra. Ana Souza";
        String crmvVet = "CRMV-MG 12345";

        System.out.println("\n[Cadastro Simulado Concluído]");
        System.out.println("Animal: " + nomeAnimal + " (" + especieAnimal + "), " + idadeAnimal + " anos.");
        System.out.println("Tutor: " + nomeTutor + " - Tel: " + telefoneTutor);
        System.out.println("Veterinário: " + nomeVeterinario + " (CRMV: " + crmvVet + ")");

        System.out.println("\n--- Simulação de Validação de Agendamento ---");
        System.out.print("Informe a data da consulta (AAAA-MM-DD): ");
        String dataStr = scanner.nextLine();
        LocalDate dataConsulta = LocalDate.parse(dataStr);

        System.out.print("Informe o horário da consulta (HH:MM): ");
        String horaStr = scanner.nextLine();
        LocalTime horaConsulta = LocalTime.parse(horaStr);

        // Regra 3: Não permitir datas passadas
        if (dataConsulta.isBefore(LocalDate.now())) {
            System.out.println("Erro: Não é possível agendar consultas em datas que já passaram.");
            scanner.close();
            return;
        }

        // Regra 1: Segunda a sexta, das 8h às 18h
        DayOfWeek diaSemana = dataConsulta.getDayOfWeek();
        boolean diaUtil = (diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY);
        boolean horarioComercial = !horaConsulta.isBefore(LocalTime.of(8, 0)) && 
                                   !horaConsulta.isAfter(LocalTime.of(18, 0));

        if (!diaUtil) {
            System.out.println("Erro: A clínica funciona apenas de segunda a sexta-feira.");
        } else if (!horarioComercial) {
            System.out.println("Erro: Horário fora do expediente (8h às 18h).");
        } else {
            System.out.println("\nSucesso! Consulta agendada para " + nomeAnimal + 
                               " com " + nomeVeterinario + 
                               " em " + dataConsulta + " às " + horaConsulta + ".");
            System.out.println("Situação atual: AGENDADA (Duração estimada: 30 minutos).");
        }

        scanner.close();
    }
}
