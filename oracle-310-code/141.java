package com.smartgwt.sample.showcase.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class Showcase implements EntryPoint{

    public void onModuleLoad() {
       RootPanel.get().add(getViewPanel());
    }
    public Canvas getViewPanel() {
      HLayout layout = new HLayout();
      layout.setWidth100();
      layout.setHeight100();
      layout.setMembersMargin(20);

      VLayout vLayout = new VLayout();
      vLayout.setShowEdges(true);
      vLayout.setWidth(150);
      vLayout.setMembersMargin(5);
      vLayout.setLayoutMargin(10);
      vLayout.addMember(new BlueBox(null, 50, "height 50"));
      vLayout.addMember(new BlueBox((String) null, "*", "height *"));
      vLayout.addMember(new BlueBox((String) null, "30%", "height 30%"));
      layout.addMember(vLayout);

      HLayout hLayout = new HLayout();
      hLayout.setShowEdges(true);
      hLayout.setHeight(150);
      hLayout.setMembersMargin(5);
      hLayout.setLayoutMargin(10);
      hLayout.addMember(new BlueBox(50, (Integer) null, "width 50"));
      hLayout.addMember(new BlueBox("*", null, "width *"));
      hLayout.addMember(new BlueBox("30%", null, "width 30%"));
      layout.addMember(hLayout);

      return layout;
  }

    class BlueBox extends Label {

        public BlueBox(String contents) {
            setAlign(Alignment.CENTER);
            setBorder("1px solid #808080");
            setBackgroundColor("lightblue");
            setContents(contents);
        }

        public BlueBox(Integer width, Integer height, String contents) {
            this(contents);
            if (width != null) setWidth(width);
            if (height != null) setHeight(height);
        }

        public BlueBox(Integer width, String height, String contents) {
            this(contents);
            if (width != null) setWidth(width);
            if (height != null) setHeight(height);
        }

        public BlueBox(String width, String height, String contents) {
            this(contents);
            if (width != null) setWidth(width);
            if (height != null) setHeight(height);
        }
    }
}