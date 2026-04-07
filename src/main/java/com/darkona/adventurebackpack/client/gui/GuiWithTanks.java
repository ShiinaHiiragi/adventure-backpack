package com.darkona.adventurebackpack.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

import org.lwjgl.input.Mouse;

/**
 * Created on 06/01/2015
 *
 * @author Darkona
 */
public abstract class GuiWithTanks extends GuiContainer
{
    public GuiWithTanks(Container p_i1072_1_)
    {
        super(p_i1072_1_);
    }

    public int getLeft()
    {
        return guiLeft;
    }

    public int getTop()
    {
        return guiTop;
    }

    public float getZLevel() {return zLevel;}

    @Override
    public void handleMouseInput()
    {
        if (Mouse.getEventDWheel() != 0)
        {
            int mouseX = Mouse.getEventX() * this.width / this.mc.displayWidth;
            int mouseY = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
            int marginX = (this.width - this.xSize) / 2;
            int marginY = (this.height - this.ySize) / 2;

            if (mouseX > marginX && mouseX < marginX + this.xSize
                    && mouseY > marginY && mouseY < marginY + this.ySize)
            {
                // Forbid scroll wheel while mouse is over the GUI.
                // Shift+Scroll on stacks of fluid containers places them into bucket slots, causing desync/duplication.
                return;
            }
        }

        super.handleMouseInput();
    }

}
