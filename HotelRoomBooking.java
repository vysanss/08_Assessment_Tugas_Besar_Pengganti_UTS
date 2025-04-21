import java.util.Date;

public class HotelRoomBooking {

    private String namaPemesan;
    private String nomorKTP;
    private String nomorTelepon;
    private String email;
    private String jenisKelamin;
    private String jenisKamar;
    private int jumlahTamu;
    private int jumlahMalam;
    private double hargaPerMalam;
    private boolean sudahDibayar;
    private Date tanggalCheckin;
    private Date tanggalCheckout;
    private boolean statusAktif;
    private Voucher voucher; // Menggunakan kelas Voucher

    public HotelRoomBooking(String namaPemesan, String nomorKTP, String nomorTelepon, String email, String jenisKelamin,
            String jenisKamar, int jumlahTamu, int jumlahMalam, double hargaPerMalam,
            Date tanggalCheckin, Date tanggalCheckout, boolean statusAktif,
            Voucher voucher, boolean sudahDibayar) {

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
        this.voucher = voucher;
        this.sudahDibayar = sudahDibayar;
    }

    public double hitungTotalBiaya() {
        double total = hargaPerMalam * jumlahMalam;
        if (jumlahTamu > 2) {
            total += (jumlahTamu - 2) * 100000;
        }
        if (voucher != null && voucher.isValid()) {
            total -= voucher.getDiskon();
        }
        if (!statusAktif) {
            total = 0;
        }
        return total;
    }

    public void cetakDetailPemesanan() {
        System.out.println("===== DETAIL PEMESANAN KAMAR =====");
        System.out.println("Nama Pemesan : " + namaPemesan);
        System.out.println("Jenis Kelamin: " + jenisKelamin);
        System.out.println("No. KTP      : " + nomorKTP);
        System.out.println("Telepon      : " + nomorTelepon);
        System.out.println("Email        : " + email);
        System.out.println("Jenis Kamar  : " + jenisKamar);
        System.out.println("Jumlah Tamu  : " + jumlahTamu);
        System.out.println("Jumlah Malam : " + jumlahMalam);
        System.out.println("Harga/Malam  : " + hargaPerMalam);
        System.out.println("Check-in     : " + tanggalCheckin);
        System.out.println("Check-out    : " + tanggalCheckout);
        System.out.println("Status Aktif : " + statusAktif);
        System.out.println("Voucher      : " + (voucher != null ? voucher.getKodeVoucher() : "Tidak Ada"));
        System.out.println("Sudah Dibayar: " + sudahDibayar);
        System.out.println("Total Biaya  : Rp " + hitungTotalBiaya());
        System.out.println("===================================");
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
