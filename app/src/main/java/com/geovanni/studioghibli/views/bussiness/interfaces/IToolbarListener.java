package com.geovanni.studioghibli.views.bussiness.interfaces;

public interface IToolbarListener {

    class ToolbarSettings {

        private int color;

        public int getColor() {
            return color;
        }

        public void setColor(int color) {
            this.color = color;
        }
    }

    void updateToolbar(String title, int imageResource);
}
