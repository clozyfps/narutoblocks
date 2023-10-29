
package net.mcreator.narutoblocks.command;

@Mod.EventBusSubscriber
public class SetJutsuMasteryCommand {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher()
				.register(Commands.literal("setjutsumastery").requires(s -> s.hasPermission(1)).then(Commands.argument("player", EntityArgument.player()).then(Commands.argument("master", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();

					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();

					Entity entity = arguments.getSource().getEntity();
					if (entity == null)
						entity = FakePlayerFactory.getMinecraft(world);

					Direction direction = entity.getDirection();

					JutsuMasterySetProcedure.execute(arguments);
					return 0;
				}))));
	}

}
