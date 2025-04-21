import java.util.Date;

public class HotelRoomBooking {

    private BookingDetails bookingDetails;
    private Voucher voucher;
    private boolean sudahDibayar;

    public HotelRoomBooking(BookingDetails bookingDetails, Voucher voucher, boolean sudahDibayar) {
        this.bookingDetails = bookingDetails;
        this.voucher = voucher;
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
        System.out.println("Voucher      : " + (voucher != null ? voucher.getKodeVoucher() : "Tidak Ada"));
        System.out.println("Sudah Dibayar: " + sudahDibayar);
        System.out.println("Total Biaya  : Rp " + hitungTotalBiaya());
        System.out.println("Tipe Tamu    : " + klasifikasiTamu());
        System.out.println("===================================");
    }

    public double hitungTotalBiaya() {
        double total = bookingDetails.getHargaPerMalam() * bookingDetails.getJumlahMalam();
        total += hitungBiayaTambahanTamu();
        if (voucher != null && voucher.isValid()) {
            total -= voucher.getDiskon();
        }
        if (!bookingDetails.isStatusAktif()) {
            total = 0;
        }
        return total;
    }

    private double hitungBiayaTambahanTamu() {
        int tambahanTamu = bookingDetails.getJumlahTamu() - 2;
        return tambahanTamu > 0 ? tambahanTamu * 100000 : 0;
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

    public void kirimEmailKonfirmasi() {
        System.out.println("Mengirim email konfirmasi ke " + bookingDetails.getEmail());
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

class Voucher {
    private String kodeVoucher;
    private double diskon;

    public Voucher(String kodeVoucher, double diskon) {
        this.kodeVoucher = kodeVoucher;
        this.diskon = diskon;
    }

    public String getKodeVoucher() {
        return kodeVoucher;
    }

    public double getDiskon() {
        return diskon;
    }

    public boolean isValid() {
        return kodeVoucher != null && kodeVoucher.length() > 3;
    }
}
