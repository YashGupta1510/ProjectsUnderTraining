
const mysql = require('mysql8');

const pool = mysql.createPool({
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'results'
});

const teacher_login_get = (req, res) => {
    res.render("teacher/teacherLogin",{ error: null});
};

const teacher_login_post = (req, res) => {
    console.log(`print reqdata  ${req.body.password}`);
    //******** Teacher Login Password **********//
    if(req.body.password == "pswd"){
        return res.redirect("/teacher/option");
    }else{ 
        return res.render("teacher/teacherLogin", {
            error : "Please Enter Correct Password"
        })
    }
};

const teacher_viewall_get = async (req, res) => {
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
            console.log(`all stud = ${data}`)
            return res.render("teacher/viewAll", {student : data})
        });
    });
    
};

const teacher_edit_get =async (req, res) => {

    console.log(`stud id= ${req.params.rollno}`)

    pool.getConnection((err, connection) => {
        if (err) {
            throw err;
        }
        let selectQuery = 'SELECT * FROM student Where rollno=?';
        let query = mysql.format(selectQuery, [req.params.rollno]);
       
        pool.query(query, (err, stud) => {
            if (err) {
                connection.release();
                console.error(err);
                return;
            }
            connection.release();
            console.log(`stud =  ${stud[0].rollno}  ${stud[0].name}  ${stud[0].dob}  ${stud[0].score}`)
            return res.render("teacher/edit", {stud : stud[0]})
        });
    });
};

const teacher_edit_post =async (req, res) => {

    pool.getConnection((err, connection) => {
        if (err) {
            throw err;
        }
      
        let updateQuery = "UPDATE student SET name = ? , dob=? ,score=? WHERE rollno = ?";
        let query = mysql.format(updateQuery, [req.body.name, req.body.dob, req.body.score, req.params.rollno]);
       
        pool.query(query, (err, response) => {
            if (err) {
                connection.release();
                console.error(err);
                return;
            }
           
            console.log(`this is post ${req.body.name} ${req.body.dob} ${req.body.score}  ${req.params.rollno}`);
        });
        connection.release();
    
        res.redirect("/teacher/viewAll")
    })


    
};
const teacher_delete_get =async (req, res) => {
    pool.getConnection((err, connection) => {
        if (err) throw err;
        let selectQuery = 'DELETE FROM student WHERE rollno=?';
        let query = mysql.format(selectQuery, [req.params.rollno]);
        pool.query(query, (err, data) => {
            if (err) {
                connection.release();
                console.error(err);
                return;
            }
            console.log(data);
            connection.release();
            return res.redirect("/teacher/viewAll");
        });
    });
    
};

const teacher_option_get = (req,res) => {
    res.render("teacher/option")
};
const teacher_add_get = (req, res) => {
    res.render("teacher/addStudent",{error: null});
};

const teacher_add_post = async (req, res) => {

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
                return res.render("teacher/addStudent", {error: "Student Already Exists"});
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
                    return res.redirect("/teacher/viewAll");

                })
            }
        })
    })
    
};

module.exports={
    teacher_login_get,
    teacher_login_post,
    teacher_viewall_get,
    teacher_edit_get,
    teacher_edit_post,
    teacher_delete_get,
    teacher_add_post,
    teacher_add_get,
    teacher_option_get
}