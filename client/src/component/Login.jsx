import { useState } from "react";
import axios from "axios";

export const Login = ({ setUser }) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [status, setStatus] = useState("");

  const submit = () => {
    axios.get("http://localhost:8080/users", {
      params: {
        email: email,
        pass: password
      }
    })
    .then(res => {
      console.log(res.data);     // backend string
      setStatus(res.data);       // display message
    })
    .catch(err => {
      console.error(err);
      setStatus("Error while logging in");
    });
  };

  return (
    <>
      <input
        type="text"
        placeholder="Email"
        onChange={e => setEmail(e.target.value)}
      />

      <input
        type="text"
        placeholder="Password"
        onChange={e => setPassword(e.target.value)}
      />

      <button onClick={submit}>Login</button>
      <div>{status}</div>
    </>
  );
};
