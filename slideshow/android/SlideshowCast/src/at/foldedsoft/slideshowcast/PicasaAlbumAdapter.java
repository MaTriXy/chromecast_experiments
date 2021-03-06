package at.foldedsoft.slideshowcast;

import java.util.List;

import com.koushikdutta.urlimageviewhelper.UrlImageViewHelper;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PicasaAlbumAdapter extends ArrayAdapter<PicasaAlbum> {

  private List<PicasaAlbum> mAlbums;
  private LayoutInflater inflater;
  
  public PicasaAlbumAdapter(Context context, int resource,
      List<PicasaAlbum> objects) {
    super(context, resource, objects);
    mAlbums = objects;
    inflater = ((Activity) context).getLayoutInflater();
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View v = convertView;
    if (v == null) {
      v = inflater.inflate(R.layout.album_item, null);
    }
    PicasaAlbum album = mAlbums.get(position);
    if (album != null) {
      TextView t = (TextView) v.findViewById(R.id.album_name);
      ImageView i = (ImageView) v.findViewById(R.id.album_thumb);
      t.setText(album.getName() + " (" + String.valueOf(album.getPhotos()) + " photos)");
      UrlImageViewHelper.setUrlDrawable(i, album.getImage());
    }
    return v;
  }
}
