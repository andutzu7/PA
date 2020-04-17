package Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CHARTS", schema = "STUDENT", catalog = "")
public class Charts {
    private long id;
    private long albumId;
    private Long sales;

    @Id
    @Column(name = "ID")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ALBUM_ID")
    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    @Basic
    @Column(name = "SALES")
    public Long getSales() {
        return sales;
    }

    public void setSales(Long sales) {
        this.sales = sales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Charts that = (Charts) o;
        return id == that.id &&
                albumId == that.albumId &&
                Objects.equals(sales, that.sales);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, albumId, sales);
    }
}
