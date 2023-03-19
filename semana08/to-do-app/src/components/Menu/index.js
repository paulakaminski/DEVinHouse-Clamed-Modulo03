import { Box, AppBar, Toolbar, Typography } from '@mui/material'

const Menu = () => {
    return (
        <Box>
          <AppBar position="static">
            <Toolbar>
                <Typography
                variant="h6"
                component="div"
                sx={{ flexGrow: 1 }}
                >
                To-Do App
            </Typography>
            </Toolbar>
          </AppBar>
        </Box>
      );
}

export default Menu;