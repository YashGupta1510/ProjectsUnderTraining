const express = require('express')
const bodyparser = require('body-parser')
const cors = require('cors')

const app = express();
const port = 5000;

app.use(bodyparser.json());
app.use(cors());


//register view engine
app.set('view engine', 'ejs');


//middleware and static files
app.use(express.static('public'))
app.use(express.json());
app.use(express.urlencoded({extended : true}));

//express layouts
var expressLayouts = require('express-ejs-layouts');
app.use(expressLayouts);
app.set('layout', 'layouts/layout');

//teacher and student routes
const teachRoutes = require('./routes/teacherRoutes')
const studRoutes = require('./routes/studentRoutes')
app.use("/teacher",teachRoutes);
app.use("/student",studRoutes);


app.listen(port,()=>console.log(`Listening on port ${port} visit http://localhost:${port}`))

//routes
app.get("/", (req, res) => {
    res.render("index");
  });

  // 404 page
app.use((req, res) => {
  res.status(404).render('404', { title: '404' });
});

