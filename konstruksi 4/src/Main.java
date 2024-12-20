import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    private static final int MAX_ITEMS = 10;

    private static TenagaKerja[] tenagaKerja = new TenagaKerja[MAX_ITEMS];
    private static PengawasProyek[] pengawasProyek = new PengawasProyek[MAX_ITEMS];
    private static Kontraktor[] kontraktor = new Kontraktor[MAX_ITEMS];
    private static GovermentProject[] projectsGov = new GovermentProject[MAX_ITEMS];
    private static PrivateProject[] projectsPri = new PrivateProject[MAX_ITEMS];
    private static ArrayList<Service> services = new ArrayList<>();
    private static ArrayList<Material> materials = new ArrayList<>();
    private static ArrayList<LaporanProyek> laporanProyekList = new ArrayList<>();

    private static int tenagaKerjaCount = 0;
    private static int pengawasProyekCount = 0;
    private static int kontraktorCount = 0;
    private static int projectCount = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistem Manajemen Proyek");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2)); // Grid untuk mengatur tombol
        frame.add(panel, BorderLayout.CENTER);

        JTextArea displayArea = new JTextArea(15, 50);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        frame.add(scrollPane, BorderLayout.SOUTH);

        // Tombol untuk fitur
        JButton createGovProjButton = new JButton("Buat Proyek Pemerintah");
        JButton createPrivProjButton = new JButton("Buat Proyek Swasta");
        JButton addTeamMemberButton = new JButton("Tambah Anggota Tim");
        JButton displayProjButton = new JButton("Tampilkan Proyek");
        JButton displayTeamButton = new JButton("Tampilkan Tim");
        JButton addServiceButton = new JButton("Tambah Service");
        JButton showServiceButton = new JButton("Tampilkan Service");
        JButton addMaterialButton = new JButton("Tambah Material");
        JButton showMaterialButton = new JButton("Tampilkan Material");
        JButton laporanProyekButton = new JButton("Laporan Proyek");

        // ActionListener untuk tombol
        createGovProjButton.addActionListener(e -> createGovProject(displayArea));
        createPrivProjButton.addActionListener(e -> createPrivateProject(displayArea));
        addTeamMemberButton.addActionListener(e -> addTeamMember(displayArea));
        displayProjButton.addActionListener(e -> displayProjects(displayArea));
        displayTeamButton.addActionListener(e -> displayTeam(displayArea));
        addServiceButton.addActionListener(e -> tambahService(displayArea));
        showServiceButton.addActionListener(e -> tampilkanService(displayArea));
        addMaterialButton.addActionListener(e -> tambahMaterial(displayArea));
        showMaterialButton.addActionListener(e -> tampilkanMaterial(displayArea));
        laporanProyekButton.addActionListener(e -> laporanProyek(displayArea));

        // Menambahkan tombol ke panel
        panel.add(createGovProjButton);
        panel.add(createPrivProjButton);
        panel.add(addTeamMemberButton);
        panel.add(displayProjButton);
        panel.add(displayTeamButton);
        panel.add(addServiceButton);
        panel.add(showServiceButton);
        panel.add(addMaterialButton);
        panel.add(showMaterialButton);
        panel.add(laporanProyekButton);

        frame.setVisible(true);
    }

    private static void createGovProject(JTextArea displayArea) {
        String govProjId = JOptionPane.showInputDialog("Masukkan ID Proyek:");
        String govProjName = JOptionPane.showInputDialog("Masukkan Nama Proyek:");
        String govLocation = JOptionPane.showInputDialog("Masukkan Lokasi:");
        int govBudget = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Anggaran:"));
        String govStatus = JOptionPane.showInputDialog("Masukkan Status:");
        String institutionName = JOptionPane.showInputDialog("Masukkan Nama Lembaga:");

        projectsGov[projectCount++] = new GovermentProject(govProjId, govProjName, govLocation, govBudget, govStatus, institutionName);
        displayArea.setText("Proyek Pemerintah Dibuat: " + govProjName);
    }

    private static void createPrivateProject(JTextArea displayArea) {
        String privProjId = JOptionPane.showInputDialog("Masukkan ID Proyek:");
        String privProjName = JOptionPane.showInputDialog("Masukkan Nama Proyek:");
        String privLocation = JOptionPane.showInputDialog("Masukkan Lokasi:");
        int privBudget = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Anggaran:"));
        String privStatus = JOptionPane.showInputDialog("Masukkan Status:");
        String clientName = JOptionPane.showInputDialog("Masukkan Nama Klien:");

        projectsPri[projectCount++] = new PrivateProject(privProjId, privProjName, privLocation, privBudget, privStatus, clientName);
        displayArea.setText("Proyek Swasta Dibuat: " + privProjName);
    }

    private static void addTeamMember(JTextArea displayArea) {
        String memberId = JOptionPane.showInputDialog("Masukkan ID Anggota Tim:");
        String memberName = JOptionPane.showInputDialog("Masukkan Nama Anggota Tim:");
        String[] roles = {"Tenaga Kerja", "Pengawas Proyek", "Kontraktor"};
        String role = (String) JOptionPane.showInputDialog(null, "Pilih Jabatan", "Jabatan", JOptionPane.QUESTION_MESSAGE, null, roles, roles[0]);

        switch (role) {
            case "Tenaga Kerja":
                tenagaKerja[tenagaKerjaCount++] = new TenagaKerja(memberId, memberName);
                break;
            case "Pengawas Proyek":
                pengawasProyek[pengawasProyekCount++] = new PengawasProyek(memberId, memberName);
                break;
            case "Kontraktor":
                kontraktor[kontraktorCount++] = new Kontraktor(memberId, memberName);
                break;
        }

        displayArea.setText("Anggota Tim Ditambahkan: " + memberName);
    }

    private static void displayProjects(JTextArea displayArea) {
        StringBuilder projects = new StringBuilder();

        for (GovermentProject govProj : projectsGov) {
            if (govProj != null) {
                projects.append("Proyek Pemerintah:\n");
                projects.append("ID: ").append(govProj.getIdProyek()).append("\n");
                projects.append("Nama: ").append(govProj.getNamaProyek()).append("\n");
                projects.append("Lokasi: ").append(govProj.getLokasi()).append("\n");
                projects.append("Anggaran: ").append(govProj.getAnggaran()).append("\n");
                projects.append("Status: ").append(govProj.getStatus()).append("\n");
                projects.append("Lembaga: ").append(govProj.getNamaLembaga()).append("\n\n");
            }
        }

        for (PrivateProject privProj : projectsPri) {
            if (privProj != null) {
                projects.append("Proyek Swasta:\n");
                projects.append("ID: ").append(privProj.getIdProyek()).append("\n");
                projects.append("Nama: ").append(privProj.getNamaProyek()).append("\n");
                projects.append("Lokasi: ").append(privProj.getLokasi()).append("\n");
                projects.append("Anggaran: ").append(privProj.getAnggaran()).append("\n");
                projects.append("Status: ").append(privProj.getStatus()).append("\n");
                projects.append("Klien: ").append(privProj.getNamaClient()).append("\n\n");
            }
        }

        displayArea.setText(projects.toString());
    }

    private static void displayTeam(JTextArea displayArea) {
        StringBuilder teamList = new StringBuilder();

        for (TenagaKerja tk : tenagaKerja) {
            if (tk != null) {
                teamList.append("Tenaga Kerja:\n");
                teamList.append("ID: ").append(tk.getId()).append("\n");
                teamList.append("Nama: ").append(tk.getNama()).append("\n\n");
            }
        }

        for (PengawasProyek pp : pengawasProyek) {
            if (pp != null) {
                teamList.append("Pengawas Proyek:\n");
                teamList.append("ID: ").append(pp.getId()).append("\n");
                teamList.append("Nama: ").append(pp.getNama()).append("\n\n");
            }
        }

        for (Kontraktor kt : kontraktor) {
            if (kt != null) {
                teamList.append("Kontraktor:\n");
                teamList.append("ID: ").append(kt.getId()).append("\n");
                teamList.append("Nama: ").append(kt.getNama()).append("\n\n");
            }
        }

        displayArea.setText(teamList.toString());
    }

    private static void tambahService(JTextArea displayArea) {
        String nama = JOptionPane.showInputDialog("Masukkan Nama Service:");
        double tarif = Double.parseDouble(JOptionPane.showInputDialog("Masukkan Tarif per Desain:"));

        String[] jenis = {"Layanan Sipil", "Layanan Arsitek"};
        String selectedJenis = (String) JOptionPane.showInputDialog(null, "Pilih Jenis Service:", "Jenis Service",
                JOptionPane.QUESTION_MESSAGE, null, jenis, jenis[0]);

        if (selectedJenis.equals("Layanan Sipil")) {
            services.add(new CivilService(nama, tarif));
        } else {
            services.add(new ArchitectService(nama, tarif));
        }

        displayArea.setText("Service berhasil ditambahkan: " + nama);
    }

    private static void tampilkanService(JTextArea displayArea) {
        StringBuilder result = new StringBuilder("Daftar Service:\n");
        for (Service service : services) {
            if (service instanceof CivilService) {
                result.append("Layanan Sipil - ");
            } else if (service instanceof ArchitectService) {
                result.append("Layanan Arsitek - ");
            }
            service.displayService();
            result.append("\n");
        }
        displayArea.setText(result.toString());
    }

    private static void tambahMaterial(JTextArea displayArea) {
        String nama = JOptionPane.showInputDialog("Masukkan Nama Material:");
        String jenis = JOptionPane.showInputDialog("Masukkan Jenis Material:");
        int stok = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Stok Material:"));
        int harga = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Harga Material:"));

        materials.add(new Material(nama, stok, harga));
        displayArea.setText("Material berhasil ditambahkan: " + nama);
    }

    private static void tampilkanMaterial(JTextArea displayArea) {
        StringBuilder result = new StringBuilder("Daftar Material:\n");
        for (Material material : materials) {
            result.append("Nama: ").append(material.getNamaMaterial())
                    .append(", Jenis: ").append(material.getNamaMaterial())
                    .append(", Stok: ").append(material.getStok())
                    .append(", Harga: ").append(material.getHarga())
                    .append("\n");
        }
        displayArea.setText(result.toString());
    }

    private static void laporanProyek(JTextArea displayArea) {
        if (laporanProyekList.isEmpty()) {
            displayArea.setText("Belum ada laporan proyek.");
            return;
        }

        StringBuilder result = new StringBuilder("Laporan Proyek:\n");
        for (LaporanProyek laporan : laporanProyekList) {
            laporan.DisplayProject();
            result.append("\n");
        }

        displayArea.setText(result.toString());
    }
}
