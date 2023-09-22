var express = require("express");
const router = express.Router();


const mysql = require('mysql8');

const pool = mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'results'
});


const student_login_get = (req, res) => {
    return res.render("student/login", { error : null});
 };

const student_login_post = async (req, res) => {
     pool.getConnection((err, connection) => {
      if (err) { 
          throw err; 
      }
      let selectQuery = 'SELECT * FROM student WHERE rollno=? AND dob=?';
      let query = mysql.format(selectQuery, [req.body.rollno, req.body.dob]);

      pool.query(query, (err, data) => {
          if (err) {
              connection.release();
              console.error(err);
              return;
          }
          if (data.length > 0) {
              connection.release();
              return res.render("student/view", { stud : data[0]});;
          }
          else {
              connection.release();
              return res.render("student/login", { error : "Invalid Credentials"});
          }
      });
  });

 };


module.exports={
  student_login_get,
  student_login_post
};