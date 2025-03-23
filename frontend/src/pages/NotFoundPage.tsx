import { Link } from 'react-router-dom';

const NotFoundPage = () => {
  return (
    <div>
      <h1>404 Not found</h1>
      Oppps ... something went wrong ❌<Link to={'/home'}>Home</Link>
    </div>
  );
};

export default NotFoundPage;
