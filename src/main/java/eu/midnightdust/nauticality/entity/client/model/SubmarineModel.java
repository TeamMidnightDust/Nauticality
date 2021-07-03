// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	package eu.midnightdust.nauticality.entity.client.model;

import eu.midnightdust.nauticality.entity.SubmarineEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class SubmarineModel extends EntityModel<SubmarineEntity> {
	private final ModelPart base;
	private final ModelPart cube_r1;
	private final ModelPart cube_r2;
	private final ModelPart door;
	private final ModelPart front;
	private final ModelPart cube_r3;
	private final ModelPart cube_r4;
	private final ModelPart cube_r5;
	private final ModelPart cube_r6;
	private final ModelPart cube_r7;
	private final ModelPart back;
	private final ModelPart rotor;
	private final ModelPart interior;
	private final ModelPart light;

	public SubmarineModel(ModelPart root) {
		this.base = root.getChild("base");
		this.door = this.base.getChild("door");
		this.cube_r2 = this.base.getChild("cube_r2");
		this.cube_r1 = this.base.getChild("cube_r1");
		this.front = root.getChild("front");
		this.cube_r7 = this.front.getChild("cube_r7");
		this.cube_r6 = this.front.getChild("cube_r6");
		this.cube_r5 = this.front.getChild("cube_r5");
		this.cube_r4 = this.front.getChild("cube_r4");
		this.cube_r3 = this.front.getChild("cube_r3");
		this.back = root.getChild("back");
		this.rotor = root.getChild("rotor");
		this.interior = root.getChild("interior");
		this.light = root.getChild("light");
		setRotationAngle(cube_r1, 0.0F, -0.6545F, 0.0F);
		setRotationAngle(cube_r2, 0.0F, 0.6545F, 0.0F);
		setRotationAngle(cube_r3, 0.3491F, 0.6545F, 0.0F);
		setRotationAngle(cube_r4, 0.3491F, -0.6545F, 0.0F);
		setRotationAngle(cube_r5, 0.3491F, 0.0F, 0.0F);
		setRotationAngle(cube_r6, 0.0F, -0.6545F, 0.0F);
		setRotationAngle(cube_r7, 0.0F, 0.6545F, 0.0F);
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData modelPartData1 = modelPartData.addChild("base", ModelPartBuilder.create().uv(0,0).cuboid(-12.0F, -1.0F, -15.0F, 24.0F, 1.0F, 30.0F).uv(78,81).cuboid(-4.0F, -1.0F, -21.0F, 8.0F, 1.0F, 6.0F).uv(0,59).cuboid(-12.0F, -23.0F, -12.0F, 1.0F, 22.0F, 27.0F).uv(56,91).cuboid(-12.0F, -22.0F, -15.0F, 1.0F, 21.0F, 3.0F).uv(18,0).cuboid(11.0F, -22.0F, -15.0F, 1.0F, 21.0F, 3.0F).uv(0,0).cuboid(11.0F, -23.0F, -12.0F, 1.0F, 22.0F, 8.0F).uv(78,7).cuboid(11.0F, -23.0F, -4.0F, 1.0F, 8.0F, 9.0F).uv(56,59).cuboid(11.0F, -23.0F, 5.0F, 1.0F, 22.0F, 10.0F).uv(0,31).cuboid(-12.0F, -24.0F, -12.0F, 24.0F, 1.0F, 27.0F).uv(78,24).cuboid(-6.0F, -24.0F, -15.0F, 12.0F, 1.0F, 3.0F).uv(29,59).cuboid(6.0F, -24.0F, -14.0F, 2.0F, 1.0F, 2.0F).uv(10,4).cuboid(-8.0F, -24.0F, -14.0F, 2.0F, 1.0F, 2.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
		modelPartData1.addChild("cube_r1", ModelPartBuilder.create().uv(78,67).cuboid(-9.5F, -0.995F, -19.0F, 9.0F, 1.0F, 6.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData1.addChild("cube_r2", ModelPartBuilder.create().uv(78,74).cuboid(0.5F, -0.995F, -19.0F, 9.0F, 1.0F, 6.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		modelPartData1.addChild("door", ModelPartBuilder.create().uv(29,59).cuboid(11.5F, -15.0F, -4.0F, 1.0F, 14.0F, 9.0F).uv(15,0).cuboid(12.0F, -9.0F, -3.0F, 1.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F,0.0F,0.0F));
		ModelPartData modelPartData2 = modelPartData.addChild("front", ModelPartBuilder.create().uv(75,34).cuboid(-4.0F, -21.99F, -21.1F, 8.0F, 22.0F, 1.0F).uv(22,31).cuboid(-4.5F, -22.0F, -21.17F, 1.0F, 22.0F, 1.0F).uv(26,0).cuboid(3.5F, -22.0F, -21.17F, 1.0F, 22.0F, 1.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
		modelPartData2.addChild("cube_r3", ModelPartBuilder.create().uv(18,24).cuboid(3.0F, -1.0F, -3.0F, 1.0F, 1.0F, 1.0F).uv(10,0).cuboid(2.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F).uv(0,0).cuboid(-7.0F, -1.0F, 0.0F, 1.0F, 1.0F, 3.0F).uv(96,99).cuboid(-6.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F).uv(40,59).cuboid(-5.0F, -1.0F, -3.0F, 7.0F, 1.0F, 6.0F), ModelTransform.pivot(-6.0F,-22.0F,-15.0F));
		modelPartData2.addChild("cube_r4", ModelPartBuilder.create().uv(0,4).cuboid(-5.0F, -1.0F, -3.0F, 1.0F, 1.0F, 3.0F).uv(18,24).cuboid(4.0F, -1.0F, -2.0F, 1.0F, 1.0F, 5.0F).uv(87,51).cuboid(-4.0F, -1.0F, -3.0F, 8.0F, 1.0F, 6.0F), ModelTransform.pivot(7.0F,-22.0F,-14.0F));
		modelPartData2.addChild("cube_r5", ModelPartBuilder.create().uv(78,0).cuboid(-5.0F, -1.0F, -3.0F, 10.0F, 1.0F, 6.0F), ModelTransform.pivot(0.0F,-22.0F,-17.0F));
		modelPartData2.addChild("cube_r6", ModelPartBuilder.create().uv(0,31).cuboid(-10.0F, -21.99F, -19.0F, 10.0F, 22.0F, 1.0F), ModelTransform.pivot(0.5F,0.0F,0.0F));
		modelPartData2.addChild("cube_r7", ModelPartBuilder.create().uv(0,59).cuboid(0.0F, -21.99F, -19.0F, 10.0F, 22.0F, 1.0F), ModelTransform.pivot(-0.5F,0.0F,0.0F));
		modelPartData.addChild("back", ModelPartBuilder.create().uv(70,91).cuboid(9.0F, -23.0F, 15.0F, 2.0F, 22.0F, 1.0F).uv(64,91).cuboid(-11.0F, -23.0F, 15.0F, 2.0F, 22.0F, 1.0F).uv(75,31).cuboid(-9.0F, -3.0F, 15.0F, 18.0F, 2.0F, 1.0F).uv(68,64).cuboid(-9.0F, -23.0F, 15.0F, 18.0F, 2.0F, 1.0F).uv(76,96).cuboid(-9.0F, -21.0F, 16.0F, 2.0F, 18.0F, 1.0F).uv(49,66).cuboid(7.0F, -21.0F, 16.0F, 2.0F, 18.0F, 1.0F).uv(89,7).cuboid(-7.0F, -5.0F, 16.0F, 14.0F, 2.0F, 1.0F).uv(78,88).cuboid(-7.0F, -21.0F, 16.0F, 14.0F, 2.0F, 1.0F).uv(92,99).cuboid(6.0F, -19.0F, 17.0F, 1.0F, 14.0F, 1.0F).uv(22,59).cuboid(-7.0F, -19.0F, 17.0F, 1.0F, 14.0F, 1.0F).uv(0,56).cuboid(-6.0F, -6.0F, 17.0F, 12.0F, 1.0F, 1.0F).uv(0,54).cuboid(-6.0F, -19.0F, 17.0F, 12.0F, 1.0F, 1.0F).uv(100,105).cuboid(-6.0F, -18.0F, 18.0F, 1.0F, 12.0F, 1.0F).uv(96,105).cuboid(5.0F, -18.0F, 18.0F, 1.0F, 12.0F, 1.0F).uv(0,82).cuboid(-5.0F, -7.0F, 18.0F, 10.0F, 1.0F, 1.0F).uv(78,28).cuboid(-5.0F, -18.0F, 18.0F, 10.0F, 1.0F, 1.0F).uv(82,107).cuboid(-5.0F, -17.0F, 19.0F, 1.0F, 10.0F, 1.0F).uv(22,74).cuboid(4.0F, -17.0F, 19.0F, 1.0F, 10.0F, 1.0F).uv(0,84).cuboid(-4.0F, -8.0F, 19.0F, 8.0F, 1.0F, 1.0F).uv(29,82).cuboid(-4.0F, -17.0F, 19.0F, 8.0F, 1.0F, 1.0F).uv(104,105).cuboid(-4.0F, -16.0F, 20.0F, 1.0F, 8.0F, 2.0F).uv(93,48).cuboid(-3.0F, -9.0F, 20.0F, 6.0F, 1.0F, 2.0F).uv(93,45).cuboid(-3.0F, -16.0F, 20.0F, 6.0F, 1.0F, 2.0F).uv(103,34).cuboid(3.0F, -16.0F, 20.0F, 1.0F, 8.0F, 2.0F).uv(98,15).cuboid(-3.0F, -15.0F, 22.0F, 6.0F, 6.0F, 1.0F).uv(92,91).cuboid(-1.0F, -13.0F, 23.0F, 2.0F, 2.0F, 6.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
		modelPartData.addChild("rotor", ModelPartBuilder.create().uv(82,96).cuboid(-1.0F, 1.0F, -2.0F, 1.0F, 7.0F, 4.0F).uv(93,34).cuboid(0.0F, -8.0F, -2.0F, 1.0F, 7.0F, 4.0F).uv(76,91).cuboid(1.0F, 0.0F, -2.0F, 7.0F, 1.0F, 4.0F).uv(89,10).cuboid(-8.0F, -1.0F, -2.0F, 7.0F, 1.0F, 4.0F), ModelTransform.pivot(0.0F,12.0F,26.0F));
		modelPartData.addChild("interior", ModelPartBuilder.create().uv(68,59).cuboid(-11.0F, -5.0F, -16.0F, 22.0F, 4.0F, 1.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));
		modelPartData.addChild("light", ModelPartBuilder.create().uv(0,119).cuboid(-2.0F, -27.01F, -19.0F, 4.0F, 4.0F, 5.0F), ModelTransform.pivot(0.0F,24.0F,0.0F));

		return TexturedModelData.of(modelData,128,128);
	}

	@Override
	public void setAngles(SubmarineEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		if (entity.isTouchingWater()) entity.rotorAngle = entity.rotorAngle + 0.1f;
		rotor.setAngles(0,0,entity.rotorAngle);
	}
	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		base.render(matrixStack, buffer, packedLight, packedOverlay);
		front.render(matrixStack, buffer, packedLight, packedOverlay);
		back.render(matrixStack, buffer, packedLight, packedOverlay);
		interior.render(matrixStack, buffer, packedLight, packedOverlay);
		rotor.render(matrixStack, buffer, packedLight, packedOverlay);
		light.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	public static void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.pitch = x;
		bone.yaw = y;
		bone.roll = z;
	}
}