import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GovermentProject[] projectsGov = new GovermentProject[10];
        PrivateProject[] projectsPri = new PrivateProject[10];
        TimPekerja[] teamMembers = new TimPekerja[10];
        Service[] services = new Service[10];
        Material[] materials = new Material[10];
        LaporanProyek[] laporanProyeks = new LaporanProyek[10];

        int projectCount = 0;
        int teamMemberCount = 0;
        int serviceCount = 0;
        int materialCount = 0;
        int laporanCount = 0;

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Create Government Project");
            System.out.println("2. Create Private Project");
            System.out.println("3. Add Team Member");
            System.out.println("4. Assign Project to Team Member");
            System.out.println("5. Create Service");
            System.out.println("6. Display Project");
            System.out.println("7. Display Team Member");
            System.out.println("8. Display Service");
            System.out.println("9. Manage Material");
            System.out.println("10. Create Project Report");
            System.out.println("11. Display Project Report");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Project ID: ");
                    String govProjId = scanner.nextLine();
                    System.out.print("Enter Project Name: ");
                    String govProjName = scanner.nextLine();
                    System.out.print("Enter Location: ");
                    String govLocation = scanner.nextLine();
                    System.out.print("Enter Budget: ");
                    int govBudget = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Status: ");
                    String govStatus = scanner.nextLine();
                    System.out.print("Enter Institution Name: ");
                    String institutionName = scanner.nextLine();

                    projectsGov[projectCount] = new GovermentProject(govProjId, govProjName, govLocation, govBudget, govStatus, institutionName);
                    projectCount++;
                    break;
                case 2:
                    System.out.print("Enter Project ID: ");
                    String privProjId = scanner.nextLine();
                    System.out.print("Enter Project Name: ");
                    String privProjName = scanner.nextLine();
                    System.out.print("Enter Location: ");
                    String privLocation = scanner.nextLine();
                    System.out.print("Enter Budget: ");
                    int privBudget = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Status: ");
                    String privStatus = scanner.nextLine();
                    System.out.print("Enter Client Name: ");
                    String clientName = scanner.nextLine();

                    projectsPri[projectCount] = new PrivateProject(privProjId, privProjName, privLocation, privBudget, privStatus, clientName);
                    projectCount++;
                    break;
                case 3:
                    System.out.println("1. Add Tenaga Kerja");
                    System.out.println("2. Add Pengawas Proyek");
                    System.out.println("3. Add Kontraktor");
                    System.out.print("Choose an option: ");
                    int memberChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter ID: ");
                    String memberId = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String memberName = scanner.nextLine();
                    //System.out.print("Enter Date of Joining (YYYY-MM-DD): ");
                    //String dateOfJoining = scanner.nextLine();
                    //Date joiningDate = Date.valueOf(dateOfJoining);

                    switch (memberChoice) {
                        case 1:
                            teamMembers[teamMemberCount] = new TenagaKerja(memberId, memberName);
                            break;
                        case 2:
                            teamMembers[teamMemberCount] = new PengawasProyek(memberId, memberName);
                            break;
                        case 3:
                            teamMembers[teamMemberCount] = new Kontraktor(memberId, memberName);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            continue;
                    }
                    teamMemberCount++;
                    break;
                case 4:
                    System.out.print("Enter Team Member ID: ");
                    String tMemberId = scanner.nextLine();
                    System.out.print("Enter Project ID: ");
                    String tProjectId = scanner.nextLine();

                    for (TimPekerja member : teamMembers) {
                        if (member != null && member.getId().equals(tMemberId)) {
                            member.TambahProyek(tProjectId);
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("1. Create Architect Service");
                    System.out.println("2. Create Civil Service");
                    System.out.print("Choose an option: ");
                    int serviceChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter Expert Name: ");
                    String expertName = scanner.nextLine();
                    System.out.print("Enter Rate per Design: ");
                    double ratePerDesign = scanner.nextDouble();
                    scanner.nextLine(); // consume newline

                    switch (serviceChoice) {
                        case 1:
                            services[serviceCount] = new ArchitectService(expertName, ratePerDesign);
                            break;
                        case 2:
                            services[serviceCount] = new CivilService(expertName, ratePerDesign);
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            continue;
                    }
                    serviceCount++;
                    break;
                case 6:
                    System.out.println("1. Proyek Pemerintah");
                    System.out.println("2. Proyek Pribadi");
                    int pilih = scanner.nextInt();
                    if (pilih == 1) {
                        for (GovermentProject govermentProject : projectsGov) {
                            if (govermentProject != null) {
                                govermentProject.displayProjectGovernment();
                            }
                        }
                    } else if (pilih == 2) {
                        for (PrivateProject project : projectsPri) {
                            if (project != null) {
                                project.displayProjectPrivate();
                            }
                        }
                    }
                    break;
                case 7:
                    for (TimPekerja member : teamMembers) {
                        if (member != null) {
                            System.out.println("ID: " + member.getId() + ", Name: " + member.getNama() + ", Project ID: " + member.getIdProyek());
                        }
                    }
                    break;
                case 8:
                    for (Service serv : services) {
                        if (serv != null) {
                            serv.displayService();
                        }
                    }
                    break;
                case 9:
                    System.out.println("1. Add Material");
                    System.out.println("2. Reduce Material");
                    System.out.println("3. Update Material Price");
                    System.out.println("4. Display Material");
                    System.out.print("Choose an option: ");
                    int materialChoice = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    System.out.print("Enter Material Name: ");
                    String materialName = scanner.nextLine();

                    Material foundMaterial = null;
                    for (Material mat : materials) {
                        if (mat != null && mat.getNamaMaterial().equals(materialName)) {
                            foundMaterial = mat;
                            break;
                        }
                    }

                    if (materialChoice != 1 && foundMaterial == null) {
                        System.out.println("Material not found.");
                        continue;
                    }

                    switch (materialChoice) {
                        case 1:
                            System.out.print("Enter Stock: ");
                            int stock = scanner.nextInt();
                            System.out.print("Enter Price: ");
                            int price = scanner.nextInt();
                            materials[materialCount] = new Material(materialName, stock, price);
                            materialCount++;
                            break;
                        case 2:
                            System.out.print("Enter Quantity to Reduce: ");
                            int reduceQty = scanner.nextInt();
                            foundMaterial.reduceMaterial(reduceQty);
                            break;
                        case 3:
                            System.out.print("Enter New Price: ");
                            int newPrice = scanner.nextInt();
                            foundMaterial.updatePriceMaterial(newPrice);
                            break;
                        case 4:
                            foundMaterial.displayMaterial();
                            break;
                        default:
                            System.out.println("Invalid choice.");
                    }
                    break;
                case 10:
                    System.out.print("Enter Project ID: ");
                    String reportProjId = scanner.nextLine();
                    Proyek foundProject = null;

                    for (GovermentProject govermentProject : projectsGov) {
                        if (govermentProject != null) {
                            govermentProject.displayProjectGovernment();
                        }
                    }
                    for (PrivateProject project : projectsPri) {
                        if (project != null) {
                            project.displayProjectPrivate();
                        }
                    }

                    if (foundProject == null) {
                        System.out.println("Project not found.");
                        continue;
                    }

                    System.out.print("Enter Report Date (YYYY-MM-DD): ");
                    String reportDate = scanner.nextLine();
                    System.out.print("Enter Project Details: ");
                    String projectDetails = scanner.nextLine();

                    laporanProyeks[laporanCount] = new LaporanProyek(foundProject, reportDate, projectDetails);
                    laporanCount++;
                    break;
                case 11:
                    for (LaporanProyek laporan : laporanProyeks) {
                        if (laporan != null) {
                            laporan.DisplayProject();
                        }
                    }
                    break;
                case 12:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}