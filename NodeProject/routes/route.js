const express = require('express')
const route = express.Router()
const mysql = require('mysql8');

const pool = mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'results'
});



route.post('/login', async (req, res) => {

    pool.getConnection((err, connection) => {
        if (err) { 
            throw err; 
        }
        let selectQuery = 'SELECT * FROM student WHERE name=? AND rollno=?';
        let query = mysql.format(selectQuery, [req.body.name, req.body.rollno]);

        pool.query(query, (err, data) => {
            if (err) {
                connection.release();
                console.error(err);
                return;
            }
            if (data.length > 0) {
                connection.release();
                return res.status(200).json({ message: "valid" });
            }
            else {
                connection.release();
                return res.status(200).json({ message: "invalid" });
            }
        });
    });

})


route.post('/add', async (req, res) => {

    pool.getConnection((err, connection) => {
        if (err) {
            throw err;
        }
        let selectQuery = 'SELECT * FROM student WHERE rollno=?'
        let query = mysql.format(selectQuery, [req.body.rollno]);
        pool.query(query, (err, data) => {
            if (err) {
                connection.release();
                console.error(err);
                return;
            }

            else if (data.length > 0) {
                console.log("This is already present => " + data);
                connection.release();
                return res.status(200).json({ message: "Already exist" });
            }

            else {
                let insertQuery = 'INSERT INTO student (rollno,name,dob,score) VALUES (?,?,?,?)';
                let Query = mysql.format(insertQuery, [req.body.rollno, req.body.name, req.body.dob, req.body.score]);
                pool.query(Query, (err, data) => {
                    if (err) {
                        connection.release();
                        console.error(err);
                        return;

                    }
                    connection.release();
                    return res.status(200).json({ message: "Added Successfully" });

                })
            }
        })
    })

})



route.post('/edit', async (req, res) => {
    pool.getConnection((err, connection) => {
        if (err) {
            throw err;
        }
      
        let updateQuery = "UPDATE student SET name = ? , dob=? ,score=? WHERE rollno = ?";
        let query = mysql.format(updateQuery, [req.body.name, req.body.dob, req.body.score, req.body.rollno]);
       
        pool.query(query, (err, response) => {
            if (err) {
                connection.release();
                console.error(err);
                return;
            }
           
            console.log(response.affectedRows);
        });
        connection.release();
        return res.status(200).json({ message: "valid" });
    })
})





route.get('/viewall', async (req, res) => {
    console.log("viewall");
    pool.getConnection((err, connection) => {
        if (err) {
            throw err;
        }
       
        let selectQuery = 'SELECT * FROM student';
        
        pool.query(selectQuery, (err, data) => {
            if (err) {
                connection.release();
                console.error(err);
                return;
            }
            connection.release();
            return res.status(200).json({ message: "valid", data: data });

        });
    });

})

route.get('/viewresult/:rollno', async (req, res) => {
    pool.getConnection((err, connection) => {
        if (err) {
            throw err;
        }
        let selectQuery = 'SELECT * FROM student Where rollno=?';
        let query = mysql.format(selectQuery, [req.params.rollno]);
       
        pool.query(query, (err, data) => {
            if (err) {
                connection.release();
                console.error(err);
                return;
            }
            connection.release();
            return res.status(200).json({message: "valid", data: data });
        });
    });

})



route.get('/delete/:rollno', async (req, res) => {

    pool.getConnection((err, connection) => {
        if (err) throw err;
        console.log('connected as id ' + connection.threadId);
        let selectQuery = 'DELETE FROM student WHERE rollno=?';
        let query = mysql.format(selectQuery, [req.params.rollno]);
        // query = SELECT * FROM `todo` where `user` = 'shahid'
        pool.query(query, (err, data) => {
            if (err) {
                connection.release();
                console.error(err);
                return;
            }
            // rows fetch
            console.log(data);
            connection.release();
            return res.status(200).json({ message: "valid" });


        });
    });

})


module.exports = route