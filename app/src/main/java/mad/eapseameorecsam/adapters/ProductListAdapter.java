package mad.eapseameorecsam.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import mad.eapseameorecsam.R;
import mad.eapseameorecsam.models.Product;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductHolder> {

    private List<Product> products;

    public ProductListAdapter(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_product, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ProductHolder holder, int position) {
        Product product = products.get(position);

        holder.productName.setText(product.getName());
        holder.imgPreview.setImageURI(Uri.parse(product.getImageUrl()));

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    static class ProductHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView imgPreview;
        TextView productName;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);

            imgPreview = itemView.findViewById(R.id.img_preview);
            productName = itemView.findViewById(R.id.product_name);
        }
    }

}
