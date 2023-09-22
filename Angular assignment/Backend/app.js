const express = require ('express');
const bodyparser =require('body-parser');
const cors=require('cors');



const app=express()
const port=3000

app.use(bodyparser.json());
app.use(cors());


app.listen(port,()=>console.log(`Listening on port ${port}`))


const routeRouter= require('./routes/route')


app.use('/',routeRouter)