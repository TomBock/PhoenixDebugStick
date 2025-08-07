# Phoenix Debug Stick

### Config.yml

```yaml
# Contains the item stack that will be used as the debug stick. Must be of type ItemStack
item:
  <ItemStack>
# List of blocks that will be ignored by the debug stick. If a block is in this list, it will not be affected by the debug stick.
ignored:
  - GRASS_BLOCK
  - CHEST
  - ...
```

### Permissions required
- `/lp group default permission set minecraft:debugstick true` Allows non-op to use debug stick
- `/lp group default permission set minecraft:debugstick.always true` Allows players to use debug stick in survival
