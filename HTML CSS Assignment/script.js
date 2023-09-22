const pageAnimation = () => {
  document.querySelector('body').style.opacity = 1;
};


let flag = false;

const onSubmit = () => {
  let gender;
  let data = [];
  let skills = [];

  const _name = document.getElementById('inputName').value;
  const _email = document.getElementById('inputEmail').value;
  const _website = document.getElementById('inputWebsite').value;
  const _image = document.getElementById('inputImage').value;
  const _gender = document.getElementsByName('gender');
  const _ele = document.getElementsByName('skills');

  for (let i = 0; i < _gender.length; i++) {
    if (_gender[i].checked) {
      gender = _gender[i].value;
    }
  }

  for (let i = 0; i < _ele.length; i++) {
    if (_ele[i].checked) {
      skills.push(_ele[i].value);
    }
  }

  data.push({
    name: _name,
    email: _email,
    website: _website,
    image: _image,
    gender: gender,
    skills: [...skills]
  });
  if (!flag) {
    showTable();
    flag = true;
  }
  addRow(data);
};

const showTable = () => {
  const temp = document.querySelector('template');
  const dataTable = temp.content.cloneNode(true);
  const enrolledSection = document.querySelector('.enrolled-section');
  const old_child = enrolledSection.children[0];
  enrolledSection.replaceChild(dataTable, old_child);
};

const addRow = (data) => {
  console.log(data);
  let table = document.getElementById('table-data');
  let rowCount = table.rows.length;
  let row = table.insertRow(rowCount);

  row.insertCell(0).innerHTML = `<td>
    <span class="font-weight-bold">${data[0].name}</span><br />
    <span>${data[0].gender}</span><br />
    <span>${data[0].email}</span><br />
    <a
      href="https://${data[0].website}"
      target="_blank"
      rel="noopener noreferrer"
      ><u>${data[0].website}</u></a
    ><br />
    ${data[0].skills.map((skill) => {
      return `<span>${skill}</span>`;
    })}
  </td>`;

  row.insertCell(1).innerHTML = `<td style="width:100px;height:120px">
                      <img src="${data[0].image}" alt="image"/>
                  </td>`;
};