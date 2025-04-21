import java.util.Date;

public class HotelRoomBooking {

    private BookingDetails bookingDetails;
    private String kodeVoucher;
    private boolean sudahDibayar;

    public HotelRoomBooking(BookingDetails bookingDetails, String kodeVoucher, boolean sudahDibayar) {
        this.bookingDetails = bookingDetails;
        this.kodeVoucher = kodeVoucher;
        this.sudahDibayar = sudahDibayar;
    }

    public void cetakDetailPemesanan() {
        System.out.println("===== DETAIL PEMESANAN KAMAR =====");
        System.out.println("Nama Pemesan : " + bookingDetails.getNamaPemesan());
        System.out.println("Jenis Kelamin: " + bookingDetails.getJenisKelamin());
        System.out.println("No. KTP      : " + bookingDetails.getNomorKTP());
        System.out.println("Telepon      : " + bookingDetails.getNomorTelepon());
        System.out.println("Email        : " + bookingDetails.getEmail());
        System.out.println("Jenis Kamar  : " + bookingDetails.getJenisKamar());
        System.out.println("Jumlah Tamu  : " + bookingDetails.getJumlahTamu());
        System.out.println("Jumlah Malam : " + bookingDetails.getJumlahMalam());
        System.out.println("Harga/Malam  : " + bookingDetails.getHargaPerMalam());
        System.out.println("Check-in     : " + bookingDetails.getTanggalCheckin());
        System.out.println("Check-out    : " + bookingDetails.getTanggalCheckout());
        System.out.println("Status Aktif : " + bookingDetails.isStatusAktif());
        System.out.println("Voucher      : " + kodeVoucher);
        System.out.println("Sudah Dibayar: " + sudahDibayar);
        System.out.println("Total Biaya  : Rp " + hitungTotalBiaya());
        System.out.println("Tipe Tamu    : " + klasifikasiTamu());
        System.out.println("===================================");
    }

    public double hitungTotalBiaya() {
        double total = bookingDetails.getHargaPerMalam() * bookingDetails.getJumlahMalam();
        if (bookingDetails.getJumlahTamu() > 2) {
            total += (bookingDetails.getJumlahTamu() - 2) * 100000;
        }
        if (kodeVoucher != null && kodeVoucher.length() > 3) {
            total -= 50000;
        }
        if (!bookingDetails.isStatusAktif()) {
            total = 0;
        }
        return total;
    }

    public String klasifikasiTamu() {
        int jumlahTamu = bookingDetails.getJumlahTamu();
        if (jumlahTamu == 1)
            return "Individu";
        else if (jumlahTamu == 2)
            return "Pasangan";
        else
            return "Keluarga";
    }
}

class BookingDetails {
    private String namaPemesan;
    private String nomorKTP;
    private String nomorTelepon;
    private String email;
    private String jenisKelamin;
    private String jenisKamar;
    private int jumlahTamu;
    private int jumlahMalam;
    private double hargaPerMalam;
    private Date tanggalCheckin;
    private Date tanggalCheckout;
    private boolean statusAktif;

    public BookingDetails(String namaPemesan, String nomorKTP, String nomorTelepon, String email, String jenisKelamin,
            String jenisKamar, int jumlahTamu, int jumlahMalam, double hargaPerMalam, Date tanggalCheckin,
            Date tanggalCheckout, boolean statusAktif) {
        this.namaPemesan = namaPemesan;
        this.nomorKTP = nomorKTP;
        this.nomorTelepon = nomorTelepon;
        this.email = email;
        this.jenisKelamin = jenisKelamin;
        this.jenisKamar = jenisKamar;
        this.jumlahTamu = jumlahTamu;
        this.jumlahMalam = jumlahMalam;
        this.hargaPerMalam = hargaPerMalam;
        this.tanggalCheckin = tanggalCheckin;
        this.tanggalCheckout = tanggalCheckout;
        this.statusAktif = statusAktif;
    }

    // Getter methods...
    public String getNamaPemesan() {
        return namaPemesan;
    }

    public String getNomorKTP() {
        return nomorKTP;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public String getEmail() {
        return email;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public String getJenisKamar() {
        return jenisKamar;
    }

    public int getJumlahTamu() {
        return jumlahTamu;
    }

    public int getJumlahMalam() {
        return jumlahMalam;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }

    public Date getTanggalCheckin() {
        return tanggalCheckin;
    }

    public Date getTanggalCheckout() {
        return tanggalCheckout;
    }

    public boolean isStatusAktif() {
        return statusAktif;
    }
}
